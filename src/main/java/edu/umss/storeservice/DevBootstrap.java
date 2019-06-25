/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice;

import edu.umss.storeservice.model.modelEasyShopping.Categoria;
import edu.umss.storeservice.model.modelEasyShopping.Producto;
import edu.umss.storeservice.repository.repositoryEasyShopping.CategoriaRepository;
import edu.umss.storeservice.repository.repositoryEasyShopping.ProductoRepository;
import edu.umss.storeservice.service.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private CategoryService categoryService;
    private ContractService contractService;
    private EmployeeService employeeService;
    private ExpenseService expenseService;
    private FeatureInstanceService featureInstanceService;
    private FeatureService featureService;
    private ItemInstanceService itemInstanceService;
    private ItemService itemService;
    private PositionService positionService;
    private SaleService saleService;
    private SubCategoryService subCategoryService;
    private ProductoRepository productoRepository;
    private CategoriaRepository categoriaRepository;

    public DevBootstrap(CategoryService categoryService, ContractService contractService,
                        EmployeeService employeeService, ExpenseService expenseService,
                        FeatureInstanceService featureInstanceService, FeatureService featureService,
                        ItemInstanceService itemInstanceService, ItemService itemService, PositionService positionService,
                        SaleService saleService, SubCategoryService subCategoryService, ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
        this.categoryService = categoryService;
        this.contractService = contractService;
        this.employeeService = employeeService;
        this.expenseService = expenseService;
        this.featureInstanceService = featureInstanceService;
        this.featureService = featureService;
        this.itemInstanceService = itemInstanceService;
        this.itemService = itemService;
        this.positionService = positionService;
        this.saleService = saleService;
        this.subCategoryService = subCategoryService;
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        // MAQUINARIA category
//        Category maquinariaCategory = new Category();
//        maquinariaCategory.setCode("MAQ");
//        maquinariaCategory.setName("MAQUINARIA");
//        categoryService.save(maquinariaCategory);
//
//        // TRACTOR subcategory
//        SubCategory tractorSubCategory = new SubCategory();
//        tractorSubCategory.setCategory(maquinariaCategory);
//        tractorSubCategory.setCode("TRA");
//        tractorSubCategory.setName("TRACTOR");
//        subCategoryService.save(tractorSubCategory);
//
//        // Taller category
//        Category tallerCategory = new Category();
//        tallerCategory.setCode("TAL");
//        tallerCategory.setName("TALLER");
//        categoryService.save(tallerCategory);
//
//
//        // montacarga subcategory
//        SubCategory montacargaSubCategory = new SubCategory();
//        montacargaSubCategory.setCategory(maquinariaCategory);
//        montacargaSubCategory.setCode("MON");
//        montacargaSubCategory.setName("MONTACARGA");
//        subCategoryService.save(montacargaSubCategory);
//
//        // tractorKubota20 Item
//        Item tractorKubota20 = new Item();
//        tractorKubota20.setCode("TRACTOR-K-20");
//        tractorKubota20.setName("TRACTOR Kubota 20 HP");
//        tractorKubota20.setSubCategory(tractorSubCategory);
//        itemService.save(tractorKubota20);
//
//        // montacargaMitsubishi2T Item
//        Item montacargaMitsubishi2T = new Item();
//        montacargaMitsubishi2T.setCode("MON-M-2T");
//        montacargaMitsubishi2T.setName("MONTACARGA MITSUBISHI 2T");
//        montacargaMitsubishi2T.setSubCategory(montacargaSubCategory);
//        itemService.save(montacargaMitsubishi2T);
//
//        // Employee Employee
//        Employee john = new Employee();
//        john.setFirstName("Pepito");
//        john.setLastName("Perez");
//
//        // Position
//        Position position = new Position();
//        position.setName("CHAPERO");
//        positionService.save(position);
//
//        // contract
//        Contract contract = new Contract();
//        contract.setEmployee(john);
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2019, Calendar.MARCH, 10);
//        contract.setInitDate(calendar.getTime());
//        contract.setPosition(position);
//
//        john.getContracts().add(contract);
//        employeeService.save(john);
//        //contractService.save(contract);

        //--------------------------------EasyShopping-----------------------------------------------------------------
        // ------ save producto------
        Categoria cat = categoriaRepository.findById((long) 1);
        Producto producto = new Producto();
        producto.setNombre("Ron Zacapa");
        producto.setMarca("Zacapa");
        producto.setDescripcion("Zacapa 23 es un ron super-premium elaborado a partir de una mezcla de rones anejados entre 6 y 23 anos, Zacapa fue distinguido durante cinco anos consecutivos como el mejor ron del mundo en el International Rum Tasting Contest y es el anico ron premium incluido en el Salon de la Fama del Ron");
        producto.setPrecio(2100.0);
        producto.setPorcentajeOferta(0);
        producto.setCategoriaId(cat);

        productoRepository.save(producto);


    }

}
