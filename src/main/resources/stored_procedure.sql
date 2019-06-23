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


