USE [master]
GO
/****** Object:  Database [PizzaHub]    Script Date: 09/07/2021 00:50:18 ******/
CREATE DATABASE [PizzaHub]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PizzaHub', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\PizzaHub.mdf' , SIZE = 4288KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'PizzaHub_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\PizzaHub_log.ldf' , SIZE = 2368KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [PizzaHub] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PizzaHub].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PizzaHub] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PizzaHub] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PizzaHub] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PizzaHub] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PizzaHub] SET ARITHABORT OFF 
GO
ALTER DATABASE [PizzaHub] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [PizzaHub] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PizzaHub] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PizzaHub] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PizzaHub] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PizzaHub] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PizzaHub] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PizzaHub] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PizzaHub] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PizzaHub] SET  ENABLE_BROKER 
GO
ALTER DATABASE [PizzaHub] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PizzaHub] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PizzaHub] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PizzaHub] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PizzaHub] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PizzaHub] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PizzaHub] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PizzaHub] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [PizzaHub] SET  MULTI_USER 
GO
ALTER DATABASE [PizzaHub] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PizzaHub] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PizzaHub] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PizzaHub] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [PizzaHub] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [PizzaHub] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'PizzaHub', N'ON'
GO
ALTER DATABASE [PizzaHub] SET QUERY_STORE = OFF
GO
USE [PizzaHub]
GO
/****** Object:  Table [dbo].[Login]    Script Date: 09/07/2021 00:50:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Login](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Login] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 09/07/2021 00:50:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[OrderID] [int] NOT NULL,
	[PizzaID] [int] NOT NULL,
	[Quantity] [int] NOT NULL,
	[size] [int] NOT NULL,
 CONSTRAINT [PK_OrderDetail] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC,
	[PizzaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 09/07/2021 00:50:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderID] [int] NOT NULL,
	[UserID] [int] NOT NULL,
	[CreateDate] [datetime] NOT NULL,
	[TotalPrice] [nchar](20) NOT NULL,
	[Comment] [nvarchar](500) NOT NULL,
	[ShippingAddress] [nvarchar](100) NOT NULL,
	[State] [nvarchar](50) NOT NULL,
	[Phone] [nchar](20) NOT NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pizza]    Script Date: 09/07/2021 00:50:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pizza](
	[PizzaID] [int] IDENTITY(1,1) NOT NULL,
	[PizzaName] [nvarchar](100) NOT NULL,
	[Image] [nvarchar](100) NOT NULL,
	[description] [nvarchar](500) NOT NULL,
	[Price] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Pizza] PRIMARY KEY CLUSTERED 
(
	[PizzaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserInfo]    Script Date: 09/07/2021 00:50:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserInfo](
	[ID] [int] NOT NULL,
	[FullName] [nvarchar](100) NOT NULL,
	[Gender] [bit] NOT NULL,
	[DOP] [date] NOT NULL,
	[Phone] [nvarchar](50) NOT NULL,
	[Address] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[RegisterDate] [date] NOT NULL,
 CONSTRAINT [PK_UserInfo] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Login] ON 

INSERT [dbo].[Login] ([ID], [UserName], [Password]) VALUES (1, N'PhatTP', N'default')
INSERT [dbo].[Login] ([ID], [UserName], [Password]) VALUES (7, N'PhatTP1', N'default')
INSERT [dbo].[Login] ([ID], [UserName], [Password]) VALUES (8, N'DatNT', N'default')
SET IDENTITY_INSERT [dbo].[Login] OFF
GO
INSERT [dbo].[UserInfo] ([ID], [FullName], [Gender], [DOP], [Phone], [Address], [Email], [RegisterDate]) VALUES (1, N'Trần Phú Phát', 1, CAST(N'2000-12-19' AS Date), N'1', N'2', N'3', CAST(N'2021-07-05' AS Date))
INSERT [dbo].[UserInfo] ([ID], [FullName], [Gender], [DOP], [Phone], [Address], [Email], [RegisterDate]) VALUES (7, N'', 0, CAST(N'2021-07-05' AS Date), N'', N'', N'', CAST(N'2021-07-05' AS Date))
INSERT [dbo].[UserInfo] ([ID], [FullName], [Gender], [DOP], [Phone], [Address], [Email], [RegisterDate]) VALUES (8, N'', 0, CAST(N'2021-07-09' AS Date), N'', N'', N'', CAST(N'2021-07-09' AS Date))
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD FOREIGN KEY([OrderID])
REFERENCES [dbo].[Orders] ([OrderID])
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD FOREIGN KEY([PizzaID])
REFERENCES [dbo].[Pizza] ([PizzaID])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[UserInfo] ([ID])
GO
ALTER TABLE [dbo].[UserInfo]  WITH CHECK ADD FOREIGN KEY([ID])
REFERENCES [dbo].[Login] ([ID])
GO
USE [master]
GO
ALTER DATABASE [PizzaHub] SET  READ_WRITE 
GO
