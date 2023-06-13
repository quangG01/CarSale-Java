CREATE DATABASE [QLBANXE]

USE [QLBANXE]


CREATE TABLE [dbo].[Admin](
	[UserName] [nvarchar](50) not NULL PRIMARY KEY,
	[Password] [nvarchar](50) not NULL 
)

CREATE TABLE [dbo].[LoaiXe](
	[MaLoaiXe] [nvarchar](50) NOT NULL PRIMARY KEY,
	[TenLoaiXe] [nvarchar](50) NULL)


CREATE TABLE [dbo].[Xe](
	[MaXe] [nvarchar](50) NOT NULL PRIMARY KEY,
	[TenXe] [nvarchar](50) NULL,
	[MaLoaiXe] [nvarchar](50) NOT NULL,
	[GiaBan] float NULL,
	[SoLuong] int NULL,
	[SoKhung] [nvarchar](50) NULL,
	[SoMay] [nvarchar](50) NULL,
	[Mau] [nvarchar](50) NULL,
	[DungTich] int NULL,
	[TinhTrang] [nvarchar](50) NULL)

ALTER TABLE [dbo].[Xe]
ADD CONSTRAINT FK_Xe_LoaiXe FOREIGN KEY (MaLoaiXe) REFERENCES [dbo].[LoaiXe] (MaLoaiXe)  ON DELETE CASCADE ON UPDATE CASCADE

CREATE TABLE [dbo].[KhachHang](
	[MaKH] [nvarchar](50) NOT NULL PRIMARY KEY,
	[TenKH] [nvarchar](50) NULL,
	[GioiTinh] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[SDT] [nvarchar](50) NULL,
	[GhiChu] [nvarchar](50) NULL)

CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nvarchar](50) NOT NULL PRIMARY KEY,
	[TenNV] [nvarchar](50) NULL,
	[GioiTinh] [nvarchar](50) NULL,
	[NgaySinh] [date] NULL,
	[DiaChi] [nvarchar](50)   NULL,
	[SDT] [nvarchar](50) NULL,
	[ChucVu] [nvarchar](50) NULL,
	[CMND] [nvarchar](50) NULL,
	[UserName] [nvarchar](50) NULL,
	[Password] [nvarchar](50) NULL)

CREATE TABLE [dbo].[HoaDonXuat](
	[MaHDX] [nvarchar](50) NOT NULL ,
	[MaNV] [nvarchar](50) NULL,
	[MaKH] [nvarchar](50) NULL,
	[NgayXuat] [nvarchar](50) NULL)

ALTER TABLE [dbo].[HoaDonXuat]
ADD CONSTRAINT PK_HoaDonXuat PRIMARY KEY (MaHDX)
ALTER TABLE [dbo].[HoaDonXuat]
ADD CONSTRAINT FK_HoaDonXuat_KhachHang FOREIGN KEY (MaKH) REFERENCES [dbo].[KhachHang] (MaKH)  ON DELETE CASCADE ON UPDATE CASCADE
ALTER TABLE [dbo].[HoaDonXuat]
ADD CONSTRAINT FK_HoaDonXuat_NhanVien FOREIGN KEY (MaNV) REFERENCES [dbo].[NhanVien] (MaNV)  ON DELETE CASCADE ON UPDATE CASCADE

CREATE TABLE [dbo].[ChiTietHDX](
	[MaHDX] [nvarchar](50) NOT NULL,
	[MaXe] [nvarchar](50) NOT NULL,
	[DonGia] [nvarchar](50) NULL,
	[SoLuong] [nvarchar](50) NULL,
	[ThueVAT] [nvarchar](50) NULL)


ALTER TABLE [dbo].[ChiTietHDX]
ADD CONSTRAINT PK_ChiTietHDX PRIMARY KEY (MaHDX, MaXe)
ALTER TABLE [dbo].[ChiTietHDX]
ADD CONSTRAINT FK_ChiTietHDX_HoaDonXuat FOREIGN KEY (MaHDX) REFERENCES [dbo].[HoaDonXuat] (MaHDX)  ON DELETE CASCADE ON UPDATE CASCADE
ALTER TABLE [dbo].[ChiTietHDX]
ADD CONSTRAINT FK_ChiTietHDX_Xe FOREIGN KEY (MaXe) REFERENCES [dbo].[Xe] (MaXe)  ON DELETE CASCADE ON UPDATE CASCADE



CREATE TABLE [dbo].[PhieuBaoHanh](
	[MaPhieuBH] [nvarchar](50) NOT NULL,
	[MaKH] [nvarchar](50) NULL,
	[MaNV] [nvarchar](50) NULL,
	[MaXe] [nvarchar](50) NULL,
	[TGBH] [nvarchar](50) NULL,
	[NgayMua] [nvarchar](50) NULL
	)
ALTER TABLE [dbo].[PhieuBaoHanh]
ADD CONSTRAINT PK_PhieuBaoHanh PRIMARY KEY (MaPhieuBH)
ALTER TABLE [dbo].[PhieuBaoHanh]
ADD CONSTRAINT FK_PhieuBaoHanh_KhachHang FOREIGN KEY (MaKH) REFERENCES [dbo].[KhachHang] (MaKH) ON DELETE CASCADE ON UPDATE CASCADE
ALTER TABLE [dbo].[PhieuBaoHanh]
ADD CONSTRAINT FK_PhieuBaoHanh_NhanVien FOREIGN KEY (MaNV) REFERENCES [dbo].[NhanVien] (MaNV) ON DELETE CASCADE ON UPDATE CASCADE
ALTER TABLE [dbo].[PhieuBaoHanh]
ADD CONSTRAINT FK_PhieuBaoHanh_Xe FOREIGN KEY (MaXe) REFERENCES [dbo].[Xe] (MaXe) ON DELETE CASCADE ON UPDATE CASCADE

INSERT INTO Admin (UserName, Password)
VALUES ('admin01', 'pass123')
       


INSERT INTO LoaiXe (MaLoaiXe, TenLoaiXe)
VALUES ('LX01', N'Xe tay ga'),
       ('LX02', N'Xe côn tay'),
       ('LX03', N'Xe số'),
       ('LX04', N'Xe địa hình'),
       ('LX05', N'Xe phân khối lớn')


INSERT INTO Xe (MaXe, TenXe, MaLoaiXe, GiaBan, SoLuong, SoKhung, SoMay, Mau, DungTich, TinhTrang)
VALUES ('X01', 'Wave Alpha', 'LX03', 20000000, 5, 'SK001', 'SM001', N'Xanh', 100, N'Mới'),
       ('X02', 'Exciter', 'LX02', 45000000, 3, 'SK002', 'SM002', N'Đen', 150, N'Cũ'),
       ('X03', 'Air Blade', 'LX01', 35000000, 2, 'SK003', 'SM003', N'Trắng', 125, N'Mới'),
       ('X04', 'Sirius', 'LX03', 25000000, 4, 'SK004', 'SM004', N'Đỏ', 100, N'Cũ'),
       ('X05', 'CRF1000L', 'LX04', 100000000, 1, 'SK005', 'SM005', N'Xanh lá', 1000, N'Mới')

INSERT INTO KhachHang (MaKH, TenKH, GioiTinh, DiaChi, SDT, GhiChu)
VALUES ('KH01', N'Nguyễn Văn A', 'Nam', N'Hà Nội', '0987654321', NULL),
       ('KH02', N'Trần Thị B', N'Nữ', N'Hồ Chí Minh', '0123456789', N'Khách hàng thân thiết'),
       ('KH03', N'Lê Văn C', N'Nam', N'Đà Nẵng', '0909090909', NULL),
       ('KH04', N'Phạm Thị D', N'Nữ', N'Hải Phòng', '0912345678', NULL),
       ('KH05', N'Hoàng Văn E', N'Nam', N'Nghệ An', '0888888888', N'Khách hàng VIP')

INSERT INTO NhanVien (MaNV, TenNV, GioiTinh, NgaySinh, DiaChi, SDT, ChucVu, CMND, UserName, Password)
VALUES ('NV03', N'Lê Thị Hương', N'Nữ', N'1990-10-05', N'Đà Nẵng', '0987456321', N'Kế toán', '123456789', 'nv03', 'pass123'),
('NV04', N'Phạm Văn Dũng', N'Nam', N'1992-02-12', N'Hà Nội', '0987123456', N'Nhân viên bán hàng', '123456789', 'nv04', 'pass123'),
('NV05', N'Nguyễn Văn E', N'Nam', N'1998-07-22', N'Hồ Chí Minh', '0987234567', N'Nhân viên sản xuất', '123456789', 'nv05', 'pass123')

INSERT INTO [dbo].[HoaDonXuat] ([MaHDX], [MaNV], [MaKH], [NgayXuat])
VALUES 
('HDX001', 'NV03', 'KH01', N'2023-05-11'),
('HDX002', 'NV03', 'KH02', N'2023-05-12'),
('HDX003', 'NV04', 'KH03', N'2023-05-12'),
('HDX004', 'NV04', 'KH04', N'2023-05-13'),
('HDX005', 'NV05', 'KH05', N'2023-05-13')

INSERT INTO [dbo].[ChiTietHDX] ([MaHDX], [MaXe], [DonGia], [SoLuong], [ThueVAT])
VALUES 
('HDX001', 'X01', '150000000', '2', '10%'),
('HDX001', 'X02', '200000000', '1', '10%'),
('HDX002', 'X03', '300000000', '1', '10%'),
('HDX003', 'X01', '150000000', '1', '10%'),
('HDX003', 'X04', '250000000', '3', '10%')

INSERT INTO [dbo].[PhieuBaoHanh] ([MaPhieuBH], [MaKH], [MaNV], [MaXe], [TGBH], [NgayMua])
VALUES 
('PBH001', 'KH01', 'NV03', 'X01', N'2 năm', N'2022-01-01'),
('PBH002', 'KH02', 'NV03', 'X02', N'1 năm', N'2022-02-02'),
('PBH003', 'KH03', 'NV04', 'X03', N'2 năm', N'2022-03-03'),
('PBH004', 'KH04', 'NV04', 'X04', N'3 năm', N'2022-04-04'),
('PBH005', 'KH05', 'NV05', 'X05', N'1 năm', N'2022-05-05')
