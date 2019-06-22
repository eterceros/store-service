
--SET ANSI_NULLS ON
--GO
--SET QUOTED_IDENTIFIER ON
--GO
--CREATE PROCEDURE [dbo].[ALL_CAR]
--AS
--  BEGIN
--    SELECT *
--    FROM Car
--  END;

--GO
 --SET ANSI_NULLS ON
--GO
--SET QUOTED_IDENTIFIER ON
--GO


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


