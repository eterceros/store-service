/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice;

import edu.umss.storeservice.model.modelEasyShopping.Categoria;
import edu.umss.storeservice.repository.repositoryEasyShopping.CaracteristicaRepository;
import edu.umss.storeservice.repository.repositoryEasyShopping.CategoriaRepository;
import edu.umss.storeservice.repository.repositoryEasyShopping.ProductoRepository;
import edu.umss.storeservice.repository.repositoryEasyShopping.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private CaracteristicaRepository caracteristicaRepository;

    public DevBootstrap(ProductoRepository productoRepository, CategoriaRepository categoriaRepository, ProveedorRepository proveedorRepository, CaracteristicaRepository caracteristicaRepository) {

        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.proveedorRepository = proveedorRepository;
        this.caracteristicaRepository = caracteristicaRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //--------------------------------EasyShopping-----------------------------------------------------------------
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>save dates<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        Categoria categoria = new Categoria();
        Categoria categoria2 = new Categoria();

        categoria.setDescripcion("REPUESTOS");
        categoria2.setDescripcion("ELECTRONICOS");
        categoria = categoriaRepository.save(categoria);
        categoria2 = categoriaRepository.save(categoria2);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>find by id<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        categoriaRepository.findById(categoria.getId());

        System.out.println("************************find all************************");
        categoriaRepository.findAll();

        System.out.println("--------------------------- delete ---------------------------");
        categoriaRepository.deleteById(categoria.getId());

        System.out.println("---------------------------* find all*----------------------------");



        /*Producto producto = new Producto();
        producto.setNombre("Ron Zacapa");
        producto.setMarca("Zacapa");
        producto.setDescripcion("Zacapa 23 es un ron super-premium elaborado a partir de una mezcla de rones anejados entre 6 y 23 anos, Zacapa fue distinguido durante cinco anos consecutivos como el mejor ron del mundo en el International Rum Tasting Contest y es el anico ron premium incluido en el Salon de la Fama del Ron");
        producto.setPrecio(2100.0);
        producto.setPorcentajeOferta(0);
        producto.setCategoriaId(categoria);

        productoRepository.save(producto);

        Proveedor proveedor = new Proveedor();
        proveedor.setCelular("773374758");
        proveedor.setName("Samsung agency");
        proveedor.setNit("989000405");
        proveedorRepository.save(proveedor);*/




    }

}
