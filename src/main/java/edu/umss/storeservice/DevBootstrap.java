/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice;

import edu.umss.storeservice.model.*;
import edu.umss.storeservice.service.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Calendar;

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

    public DevBootstrap(CategoryService categoryService, ContractService contractService,
            EmployeeService employeeService, ExpenseService expenseService,
            FeatureInstanceService featureInstanceService, FeatureService featureService,
            ItemInstanceService itemInstanceService, ItemService itemService, PositionService positionService,
            SaleService saleService, SubCategoryService subCategoryService) {
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
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        // MAQUINARIA category
        Category maquinariaCategory = new Category();
        maquinariaCategory.setCode("MAQ");
        maquinariaCategory.setName("MAQUINARIA");
        categoryService.save(maquinariaCategory);

        // TRACTOR subcategory
        SubCategory tractorSubCategory = new SubCategory();
        tractorSubCategory.setCategory(maquinariaCategory);
        tractorSubCategory.setCode("TRA");
        tractorSubCategory.setName("TRACTOR");
        subCategoryService.save(tractorSubCategory);

        // MOTOCULTOR subcategory
        SubCategory motocultorSubCategory = new SubCategory();
        motocultorSubCategory.setCategory(maquinariaCategory);
        motocultorSubCategory.setCode("MOT");
        motocultorSubCategory.setName("MOTOCULTOR");
        subCategoryService.save(motocultorSubCategory);

        // Taller category
        Category tallerCategory = new Category();
        tallerCategory.setCode("TAL");
        tallerCategory.setName("TALLER");
        categoryService.save(tallerCategory);


        // montacarga subcategory
        SubCategory montacargaSubCategory = new SubCategory();
        montacargaSubCategory.setCategory(maquinariaCategory);
        montacargaSubCategory.setCode("MON");
        montacargaSubCategory.setName("MONTACARGA");
        subCategoryService.save(montacargaSubCategory);

        //feature
        Feature feature1 = new Feature();
        feature1.setName("feature1");
        feature1 = featureService.save(feature1);

        Feature feature2 = new Feature();
        feature2.setName("feature2");
        feature2 = featureService.save(feature2);

        Feature feature3 = new Feature();
        feature3.setName("feature3");
        feature3 = featureService.save(feature3);


        // tractorKubota10 Item
        Item tractorKubota10 = saveItem(tractorSubCategory, "TRACTOR-K-10", "Tractor Kubota 10.5 Hp",
                "Tractor útil para arado en superficies regulares sin pendientes pronunciadas. Modelo JB11XA, Con " +
                        "Rotocultor, Diesel, 4x4, 10,5 HP. Año 2015");
        saveItemInstance(tractorKubota10, true);
        saveFeatureInstance(feature1, tractorKubota10, "valor1");


        // tractorKubota20 Item
        Item tractorKubota20 = saveItem(tractorSubCategory, "TRACTOR-K-20", "Tractor kubota con pala 20Hp",
                "Tractor útil para arado en superficies con pendientes pronunciadas, para situaciones de alto " +
                        "esfuerzo. Modelo L1-20DT, Con Rotocultor, Diesel 4x4, 20 HP, Con Pala.");
        saveItemInstance(tractorKubota20, false);
        saveFeatureInstance(feature2, tractorKubota20, "valor2");

        // motocultor Item
        Item motocultor = saveItem(motocultorSubCategory, "MOT-M-3", "Motocultor yanmar 250",
                "Motocultor útil para arado en superficies de dificil acceso, con espacios reducidos, para " +
                        "situaciones de alto esfuerzo. Arado De Mano Modelo YC80, Diesel.");
        saveItemInstance(motocultor, false);
        saveFeatureInstance(feature3, motocultor, "valor3");

        // montacargaMitsubishi2T Item
        Item montacargaMitsubishi2T = saveItem(montacargaSubCategory, "MON-M-2T", "Montacarga",
                "Hechos pensados en la industria donde la exigencia del equipo es frecuente. Komatsu BOBLE, ALTURA " +
                        "ELEVANTE 3,0 MTS");
        saveItemInstance(montacargaMitsubishi2T, false);

        // Employee Employee
        Employee john = new Employee();
        john.setFirstName("Pepito");
        john.setLastName("Perez");

        // Position
        Position position = new Position();
        position.setName("CHAPERO");
        positionService.save(position);

        // contract
        Contract contract = new Contract();
        contract.setEmployee(john);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.MARCH, 10);
        contract.setInitDate(calendar.getTime());
        contract.setPosition(position);

        john.getContracts().add(contract);
        employeeService.save(john);
        //contractService.save(contract);
    }

    private void saveFeatureInstance(Feature feature1, Item tractorKubota10, String value) {
        //Feature instance
        FeatureInstance featureInstance1 = new FeatureInstance();
        featureInstance1.setFeature(feature1);
        featureInstance1.setValue(value);
        featureInstance1.setItem(tractorKubota10);
        featureInstanceService.save(featureInstance1);
    }

    private ItemInstance saveItemInstance(Item tractorKubota10, boolean featured) {
        ItemInstance itemInstance = new ItemInstance();
        itemInstance.setFeatured(featured);
        itemInstance.setItem(tractorKubota10);
        itemInstance.setPrice(19000.5);
        return itemInstanceService.save(itemInstance);
    }

    private Item saveItem(SubCategory tractorSubCategory, String code, String name, String description) {
        Item item = new Item();
        item.setCode(code);
        item.setName(name);
        item.setDescription(description);
        item.setSubCategory(tractorSubCategory);
        return itemService.save(item);
    }

}
