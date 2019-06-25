/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice;

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
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>save dates<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//        Categoria categoria = new Categoria();
//        Categoria categoria2 = new Categoria();
//
//        categoria.setDescripcion("REPUESTOS");
//        categoria2.setDescripcion("ELECTRONICOS");
//        categoria = categoriaRepository.save(categoria);
//        categoria2 = categoriaRepository.save(categoria2);
//
//        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>find by id<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//        categoriaRepository.findById(categoria.getId());
//
//        System.out.println("\n************************find all************************");
//        categoriaRepository.findAll();
//
//        System.out.println("\n--------------------------- delete ---------------------------");
//        categoriaRepository.deleteById(categoria.getId());
//
////        System.out.println("---------------------------* find all*----------------------------");
////
//        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>save Producto<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//
//        Producto producto = new Producto();
//        producto.setNombre("Ron Zacapa");
//        producto.setMarca("Zacapa");
//        producto.setDescripcion("Zacapa 23 es un ron super-premium elaborado a partir de una mezcla de rones anejados entre 6 y 23 anos, Zacapa fue distinguido durante cinco anos consecutivos como el mejor ron del mundo en el International Rum Tasting Contest y es el anico ron premium incluido en el Salon de la Fama del Ron");
//        producto.setPrecio(2100.0);
//        producto.setPorcentajeOferta(0);
//        producto.setCategoriaId(categoria2);
//
//        producto = productoRepository.save(producto);
//
//        Producto producto2 = new Producto();
//        producto2.setNombre("Tablet");
//        producto2.setMarca("HP");
//        producto2.setDescripcion("i5");
//        producto2.setPrecio(5100.0);
//        producto2.setPorcentajeOferta(0);
//        producto2.setCategoriaId(categoria2);
//
//        producto2 = productoRepository.save(producto2);
//
//        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>find by id<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//
//        productoRepository.findById(producto.getId());
//
//        System.out.println("\n************************find all************************");
//productoRepository.findAll();
//
//        System.out.println("\n************************delete producto************************");
//        productoRepository.deleteById(producto.getId());
//
//        System.out.println("\n************************Insert Proveedor************************");
//
//        Proveedor proveedor = new Proveedor();
//        proveedor.setCelular("773374758");
//        proveedor.setName("Samsung agency");
//        proveedor.setNit("989000405");
//        proveedorRepository.save(proveedor);
//



    }

}
