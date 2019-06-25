//----------------------------------producto-----------------
CREATE procedure GET_ALL_PRODUCTO
as
  SET XACT_ABORT ON;
  SET NOCOUNT ON;
  BEGIN
    select *
    from producto
  END
GO

CREATE procedure GET_PRODUCTO_BY_ID
  (
    @idProducto int
  )
as
  SET XACT_ABORT ON;
  SET NOCOUNT ON;
  BEGIN
    select *
    from dbo.producto	pro
    where pro.id = @idProducto;
  END
GO

CREATE procedure DELETE_PRODUCTO
  (
    @idProducto int
  )
as
  SET XACT_ABORT ON;
  SET NOCOUNT ON;
  BEGIN
    delete from producto where id = @idProducto;
  END
GO

create procedure INSERT_PRODUCTO
  (
    @descripcion varchar(255),
    @marca varchar(50),
    @nombre varchar(50),
    @porcentaje_oferta int,
    @precio float,
    @fk_categoria int

  )
as
  SET XACT_ABORT ON;
  SET NOCOUNT ON;
  BEGIN
    INSERT INTO dbo.Producto (nombre, marca,descripcion,precio,porcentaje_oferta, fk_categoria)
    VALUES (@nombre,@marca,@descripcion,@precio,@porcentaje_oferta,@fk_categoria);
    select * from producto where id=@@IDENTITY;
  END
GO
------------------------------- producto end ----------------------------------------------

CREATE procedure GET_ALL_CATEGORIA
as
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	select *
	from Categoria
END
GO


CREATE procedure GET_CATEGORIA_BY_ID
(
	@idCategoria int
)
as
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	select *
	from dbo.Categoria	categoria
	where categoria.id = @idCategoria;
END
GO


CREATE procedure DELETE_CATEGORIA
(
	@idCategoria int
)
as
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	delete from Categoria where id = @idCategoria;
END
GO

create procedure DELETE_CATEGORIA
(
	@idCategoria int
)
as
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	select * from Categoria where id = @idCategoria;
	delete from Categoria where id = @idCategoria;
END
GO

create procedure INSERT_CATEGORIA
(
	@descripcion varchar(50)
)
as
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	insert into Categoria(descripcion)values(@descripcion);
	select * from Categoria where id=@@IDENTITY;
END
GO

//----------------------------------Caracteristica-----------------
CREATE procedure GET_ALL_CARACTERISTICA
as
  SET XACT_ABORT ON;
  SET NOCOUNT ON;
  BEGIN
    select *
    from caracteristica
  END
GO

CREATE procedure GET_CARACTERISTICA_BY_ID
  (
    @idCaracteristica int
  )
as
  SET XACT_ABORT ON;
  SET NOCOUNT ON;
  BEGIN
    select *
    from dbo.caracteristica	carac
    where carac.id = @idCaracteristica;
  END
GO

CREATE procedure DELETE_CARACTERISTICA
  (
    @idCaracteristica int
  )
as
  SET XACT_ABORT ON;
  SET NOCOUNT ON;
  BEGIN
    delete from caracteristica where id = @idCaracteristica;
  END
GO

create procedure INSERT_CARACTERISTICA
  (
    @campo varchar(150),
    @valor varchar(150),
    @fk_producto int

  )
as
  SET XACT_ABORT ON;
  SET NOCOUNT ON;
  BEGIN
    INSERT INTO dbo.Caracteristica (campo, valor,fk_producto)
    VALUES (@campo,@valor,@fk_producto);
    select * from caracteristica where id=@@IDENTITY;
  END
GO
------------------------------- Final de Caracteristica ----------------------------------------------

-----------------------PROVEEDOR PROCEDURE---------------------------------------------------

CREATE procedure GET_ALL_PROVEEDOR
as
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	select *
	from proveedor
END
GO
----------------------------------------------------

CREATE procedure GET_PROVEEDOR_BY_ID
(
	@idProveedor int
)
as
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	select *
	from dbo.proveedor proveedor
	where proveedor.id = @idProveedor;
END
GO

--------------------------------------------------
CREATE procedure DELETE_PROVEEDOR
(
	@idProveedor int
)
as
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	delete from proveedor where id = @idProveedor;
END
GO
-------------------------------------------------
create procedure INSERT_PROVEEDOR
(
	@celular varchar(50),
	@name varchar(50),
	@nit varchar(50)
)
as
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	insert into proveedor(celular,name,nit) values(@celular,@name,@nit);
	select * from proveedor where id=@@IDENTITY;
END
GO

