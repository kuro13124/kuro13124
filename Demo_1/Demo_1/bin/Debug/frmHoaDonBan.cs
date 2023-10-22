using Demo_1.Class;
using System;
using System.Windows.Forms;
using System.Data.SqlClient;
using COMExcel = Microsoft.Office.Interop.Excel;
using System.Data;

namespace Demo_1
{
    public partial class frmHoaDonBan : Form
    {
        DataTable tblCTHDB; //Bảng chi tiết hoá đơn bán
        public frmHoaDonBan()
        {
            InitializeComponent();
        }
        private void LoadDataGridView()
        {
            string sql;
            sql = "SELECT a.MaBang, b.TenBang, a.SoLuong, b.DonGiaBan, a.GiamGia,a.ThanhTien FROM tblChiTietPhieuMuon AS a, tblBang AS b WHERE a.MaHDBan = N'" + txtMaHDBan.Text + "' AND a.MaBang=b.MaBang";
            tblCTHDB = Functions.GetDataToTable(sql);
            dgvHDBanHang.DataSource = tblCTHDB;
            dgvHDBanHang.Columns[0].HeaderText = "Mã hàng";
            dgvHDBanHang.Columns[1].HeaderText = "Tên hàng";
            dgvHDBanHang.Columns[2].HeaderText = "Số lượng";
            dgvHDBanHang.Columns[3].HeaderText = "Đơn giá";
            dgvHDBanHang.Columns[4].HeaderText = "% Cọc";
            dgvHDBanHang.Columns[5].HeaderText = "Tiền Cọc";
            dgvHDBanHang.Columns[0].Width = 80;
            dgvHDBanHang.Columns[1].Width = 130;
            dgvHDBanHang.Columns[2].Width = 80;
            dgvHDBanHang.Columns[3].Width = 90;
            dgvHDBanHang.Columns[4].Width = 90;
            dgvHDBanHang.Columns[5].Width = 90;
            dgvHDBanHang.AllowUserToAddRows = false;
            dgvHDBanHang.EditMode = DataGridViewEditMode.EditProgrammatically;
        }

        private void frmHoaDonBan_Load(object sender, EventArgs e)
        {
            btnThem.Enabled = true;
            btnLuu.Enabled = false;
            btnXoa.Enabled = false;
            //btnInHoaDon.Enabled = false;
            txtMaHDBan.ReadOnly = true;
            //txtTenNhanVien.ReadOnly = true;
            txtTenKhach.ReadOnly = true;
            txtDiaChi.ReadOnly = true;
            txtDienThoai.ReadOnly = true;
            txtTenBang.ReadOnly = true;
            txtDonGiaBan.ReadOnly = true;
            txtThanhTien.ReadOnly = true;
            txtTongTien.ReadOnly = true;
            txtGiamGia.Text = "30";
            txtTongTien.Text = "0";
            Functions.FillCombo("SELECT MaKhach, TenKhach FROM tblKhach", cboMaKhach, "MaKhach", "MaKhach");
            cboMaKhach.SelectedIndex = -1;
            //Functions.FillCombo("SELECT MaNhanVien, TenNhanVien FROM tblNhanVien", cboMaNhanVien, "MaNhanVien", "TenKhach");
            //cboMaNhanVien.SelectedIndex = -1;
            Functions.FillCombo("SELECT MaBang,TenBang FROM tblBang", cboMaBang, "MaBang", "MaBang");
            cboMaBang.SelectedIndex = -1;
            //Hiển thị thông tin của một hóa đơn được gọi từ form tìm kiếm
            if (txtMaHDBan.Text != "")
            {
                LoadInfoHoaDon();
                btnXoa.Enabled = true;
                //btnInHoaDon.Enabled = true;
            }
            LoadDataGridView();
        }
        private void LoadInfoHoaDon()
        {
            string str;
            str = "SELECT NgayBan FROM tblPhieuMuon WHERE MaHDBan = N'" + txtMaHDBan.Text + "'";
            dtpNgayBan.Value = DateTime.Today;//(Functions.GetFieldValues(str));
            str = "SELECT NgayTra FROM tblPhieuMuon WHERE MaHDBan = N'" + txtMaHDBan.Text + "'";
            dtpNgayTra.Value = DateTime.Now.AddDays(10);//(Functions.GetFieldValues(str));
            //str = "SELECT MaNhanVien FROM tblPhieuMuon WHERE MaHDBan = N'" + txtMaHDBan.Text + "'";
            //cboMaNhanVien.SelectedValue = Functions.GetFieldValues(str);
            str = "SELECT MaKhach FROM tblPhieuMuon WHERE MaHDBan = N'" + txtMaHDBan.Text + "'";
            cboMaKhach.SelectedValue = Functions.GetFieldValues(str);
            str = "SELECT TongTien FROM tblPhieuMuon WHERE MaHDBan = N'" + txtMaHDBan.Text + "'";
            txtTongTien.Text = Functions.GetFieldValues(str);
            //lblBangChu.Text = "Bằng chữ: " + Functions.ChuyenSoSangChu(txtTongTien.Text);
        }
        
        private void ResetValues()
        {
            txtMaHDBan.Text = "";
            dtpNgayBan.Value = DateTime.Now;
            dtpNgayTra.Value = DateTime.Now.AddDays(10);
            //cboMaNhanVien.Text = "";
            cboMaKhach.Text = "";
            txtTongTien.Text = "0";
            //lblBangChu.Text = "Bằng chữ: ";
            cboMaBang.Text = "";
            txtSoLuong.Text = "";
            txtGiamGia.Text = "30";
            txtThanhTien.Text = "0";
        }
        
        private void ResetValuesHang()
        {
            cboMaBang.Text = "";
            txtSoLuong.Text = "";
            txtGiamGia.Text = "30";
            txtThanhTien.Text = "0";
        }

        private void btnThem_Click_1(object sender, EventArgs e)
        {
            btnXoa.Enabled = false;
            btnLuu.Enabled = true;
            //btnInHoaDon.Enabled = false;
            btnThem.Enabled = false;
            ResetValues();
            txtMaHDBan.Text = Functions.CreateKey("HDB");
            LoadDataGridView();
        }

        private void btnLuu_Click_1(object sender, EventArgs e)
        {
            string sql;
            double sl, SLcon, tong, Tongmoi;
            sql = "SELECT MaHDBan FROM tblPhieuMuon WHERE MaHDBan=N'" + txtMaHDBan.Text + "'";
            if (!Functions.CheckKey(sql))
            {
                // Mã hóa đơn chưa có, tiến hành lưu các thông tin chung
                // Mã HDBan được sinh tự động do đó không có trường hợp trùng khóa
                /*if (dtpNgayBan.Text.Length == 0)
                {
                    MessageBox.Show("Bạn phải nhập ngày bán", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    txtNgayBan.Focus();
                    return;
                }*/
                /*if (cboMaNhanVien.Text.Length == 0)
                {
                    MessageBox.Show("Bạn phải nhập nhân viên", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    cboMaNhanVien.Focus();
                    return;
                }*/
                if (cboMaKhach.Text.Length == 0)
                {
                    MessageBox.Show("Bạn phải nhập khách hàng", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    cboMaKhach.Focus();
                    return;
                }
                sql = "INSERT INTO tblPhieuMuon(MaHDBan, NgayBan,NgayTra, MaKhach, TongTien) VALUES (N'" + txtMaHDBan.Text.Trim() + "','" +
                       dtpNgayBan.Value + "',N'" + dtpNgayTra.Value + "',N'" +
                        cboMaKhach.SelectedValue + "'," + txtTongTien.Text + ")";
                Functions.RunSQL(sql);
            }
            // Lưu thông tin của các mặt hàng
            if (cboMaBang.Text.Trim().Length == 0)
            {
                MessageBox.Show("Bạn phải nhập mã hàng", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                cboMaBang.Focus();
                return;
            }
            if ((txtSoLuong.Text.Trim().Length == 0) || (txtSoLuong.Text == "0"))
            {
                MessageBox.Show("Bạn phải nhập số lượng", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                txtSoLuong.Text = "";
                txtSoLuong.Focus();
                return;
            }
            if (txtGiamGia.Text.Trim().Length == 0)
            {
                MessageBox.Show("Bạn phải nhập giảm giá", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                txtGiamGia.Focus();
                return;
            }
            sql = "SELECT MaBang FROM tblChiTietPhieuMuon WHERE MaBang=N'" + cboMaBang.SelectedValue + "' AND MaHDBan = N'" + txtMaHDBan.Text.Trim() + "'";
            if (Functions.CheckKey(sql))
            {
                MessageBox.Show("Mã hàng này đã có, bạn phải nhập mã khác", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                ResetValuesHang();
                cboMaBang.Focus();
                return;
            }
            // Kiểm tra xem số lượng hàng trong kho còn đủ để cung cấp không?
            sl = Convert.ToDouble(Functions.GetFieldValues("SELECT SoLuong FROM tblBang WHERE MaBang = N'" + cboMaBang.SelectedValue + "'"));
            if (Convert.ToDouble(txtSoLuong.Text) > sl)
            {
                MessageBox.Show("Số lượng mặt hàng này chỉ còn " + sl, "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                txtSoLuong.Text = "";
                txtSoLuong.Focus();
                return;
            }
            sql = "INSERT INTO tblChiTietPhieuMuon(MaHDBan,MaBang,SoLuong,DonGia, GiamGia,ThanhTien) VALUES(N'" + txtMaHDBan.Text.Trim() + "',N'" + cboMaBang.SelectedValue + "'," + txtSoLuong.Text + "," + txtDonGiaBan.Text + "," + txtGiamGia.Text + "," + txtThanhTien.Text + ")";
            Functions.RunSQL(sql);
            LoadDataGridView();
            // Cập nhật lại số lượng của mặt hàng vào bảng tblBang
            SLcon = sl - Convert.ToDouble(txtSoLuong.Text);
            sql = "UPDATE tblBang SET SoLuong =" + SLcon + " WHERE MaBang= N'" + cboMaBang.SelectedValue + "'";
            Functions.RunSQL(sql);
            // Cập nhật lại tổng tiền cho hóa đơn bán
            tong = Convert.ToDouble(Functions.GetFieldValues("SELECT TongTien FROM tblPhieuMuon WHERE MaHDBan = N'" + txtMaHDBan.Text + "'"));
            Tongmoi = tong + Convert.ToDouble(txtThanhTien.Text);
            sql = "UPDATE tblPhieuMuon SET TongTien =" + Tongmoi + " WHERE MaHDBan = N'" + txtMaHDBan.Text + "'";
            Functions.RunSQL(sql);
            txtTongTien.Text = Tongmoi.ToString();
            //lblBangChu.Text = "Bằng chữ: " + Functions.ChuyenSoSangChu(Tongmoi.ToString());
            ResetValuesHang();
            btnXoa.Enabled = true;
            btnThem.Enabled = true;
            //btnInHoaDon.Enabled = true;
        }

        

        private void cboMaKhach_SelectedIndexChanged(object sender, EventArgs e)
        {
            string str;
            if (cboMaKhach.Text == "")
            {
                txtTenKhach.Text = "";
                txtDiaChi.Text = "";
                txtDienThoai.Text = "";
            }
            //Khi chọn Mã khách hàng thì các thông tin của khách hàng sẽ hiện ra
            str = "Select TenKhach from tblKhach where MaKhach = N'" + cboMaKhach.SelectedValue + "'";
            txtTenKhach.Text = Functions.GetFieldValues(str);
            str = "Select DiaChi from tblKhach where MaKhach = N'" + cboMaKhach.SelectedValue + "'";
            txtDiaChi.Text = Functions.GetFieldValues(str);
            str = "Select DienThoai from tblKhach where MaKhach= N'" + cboMaKhach.SelectedValue + "'";
            txtDienThoai.Text = Functions.GetFieldValues(str);
        }

        private void txtSoLuong_TextChanged(object sender, EventArgs e)
        {
            //Khi thay đổi số lượng thì thực hiện tính lại thành tiền
            double tt, sl, dg, gg;
            if (txtSoLuong.Text == "")
                sl = 0;
            else
                sl = Convert.ToDouble(txtSoLuong.Text);
            if (txtGiamGia.Text == "")
                gg = 0;
            else
                gg = Convert.ToDouble(txtGiamGia.Text);
            if (txtDonGiaBan.Text == "")
                dg = 0;
            else
                dg = Convert.ToDouble(txtDonGiaBan.Text);
            tt = sl * dg - sl * dg * gg / 100;
            txtThanhTien.Text = tt.ToString();
        }

        private void cboMaBang_SelectedIndexChanged(object sender, EventArgs e)
        {
            string str;
            if (cboMaBang.Text == "")
            {
                txtTenBang.Text = "";
                txtDonGiaBan.Text = "";
                txtType.Text = "";
                txtTenTacGia.Text = "";
            }
            // Khi chọn mã hàng thì các thông tin về hàng hiện ra
            str = "SELECT TenBang FROM tblBang WHERE MaBang =N'" + cboMaBang.SelectedValue + "'";
            txtTenBang.Text = Functions.GetFieldValues(str);
            str = "SELECT DonGiaBan FROM tblBang WHERE MaBang =N'" + cboMaBang.SelectedValue + "'";
            txtDonGiaBan.Text = Functions.GetFieldValues(str);
            str = "SELECT Type FROM tblBang WHERE MaBang =N'" + cboMaBang.SelectedValue + "'";
            txtType.Text = Functions.GetFieldValues(str);
            str = "SELECT TacGia FROM tblBang WHERE MaBang =N'" + cboMaBang.SelectedValue + "'";
            txtTenTacGia.Text = Functions.GetFieldValues(str);
        }

        private void cboMaHD_DropDown(object sender, EventArgs e)
        {
            Functions.FillCombo("SELECT MaHDBan FROM tblPhieuMuon", cboMaHD, "MaHDBan", "MaHDBan");
            cboMaHD.SelectedIndex = -1;
        }

        private void btnTimKiem_Click(object sender, EventArgs e)
        {
            if (cboMaHD.Text == "")
            {
                MessageBox.Show("Bạn phải chọn một mã hóa đơn để tìm", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                cboMaHD.Focus();
                return;
            }
            txtMaHDBan.Text = cboMaHD.Text;
            LoadInfoHoaDon();
            LoadDataGridView();
            btnXoa.Enabled = true;
            btnLuu.Enabled = true;
            //btnInHoaDon.Enabled = true;
            cboMaHD.SelectedIndex = -1;
        }

        private void btnXoa_Click(object sender, EventArgs e)
        {
            double sl, slcon, slxoa;
            if (MessageBox.Show("Bạn có chắc chắn muốn xóa không?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
            {
                string sql = "SELECT MaBang,SoLuong FROM tblChiTietPhieuMuon WHERE MaHDBan = N'" + txtMaHDBan.Text + "'";
                DataTable tblBang = Functions.GetDataToTable(sql);
                for (int hang = 0; hang <= tblBang.Rows.Count - 1; hang++)
                {
                    // Cập nhật lại số lượng cho các mặt hàng
                    sl = Convert.ToDouble(Functions.GetFieldValues("SELECT SoLuong FROM tblBang WHERE MaBang = N'" + tblBang.Rows[hang][0].ToString() + "'"));
                    slxoa = Convert.ToDouble(tblBang.Rows[hang][1].ToString());
                    slcon = sl + slxoa;
                    sql = "UPDATE tblBang SET SoLuong =" + slcon + " WHERE MaBang= N'" + tblBang.Rows[hang][0].ToString() + "'";
                    Functions.RunSQL(sql);
                }

                //Xóa chi tiết hóa đơn
                sql = "DELETE tblChiTietPhieuMuon WHERE MaHDBan=N'" + txtMaHDBan.Text + "'";
                Functions.RunSqlDel(sql);

                //Xóa hóa đơn
                sql = "DELETE tblPhieuMuon WHERE MaHDBan=N'" + txtMaHDBan.Text + "'";
                Functions.RunSqlDel(sql);
                ResetValues();
                LoadDataGridView();
                btnXoa.Enabled = false;
                //btnInHoaDon.Enabled = false;
            }
        }

        private void btnInHoaDon_Click(object sender, EventArgs e)
        {

        }

        private void btnDong_Click(object sender, EventArgs e)
        {

        }

        private void dgvHDBanHang_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            string MaBangxoa, sql;
            Double ThanhTienxoa, SoLuongxoa, sl, slcon, tong, tongmoi;
            if (tblCTHDB.Rows.Count == 0)
            {
                MessageBox.Show("Không có dữ liệu!", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if ((MessageBox.Show("Bạn có chắc chắn muốn xóa không?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes))
            {
                //Xóa hàng và cập nhật lại số lượng hàng 
                MaBangxoa = dgvHDBanHang.CurrentRow.Cells["MaBang"].Value.ToString();
                SoLuongxoa = Convert.ToDouble(dgvHDBanHang.CurrentRow.Cells["SoLuong"].Value.ToString());
                ThanhTienxoa = Convert.ToDouble(dgvHDBanHang.CurrentRow.Cells["ThanhTien"].Value.ToString());
                sql = "DELETE tblChiTietPhieuMuon WHERE MaHDBan=N'" + txtMaHDBan.Text + "' AND MaBang = N'" + MaBangxoa + "'";
                Functions.RunSQL(sql);
                // Cập nhật lại số lượng cho các mặt hàng
                sl = Convert.ToDouble(Functions.GetFieldValues("SELECT SoLuong FROM tblBang WHERE MaBang = N'" + MaBangxoa + "'"));
                slcon = sl + SoLuongxoa;
                sql = "UPDATE tblBang SET SoLuong =" + slcon + " WHERE MaBang= N'" + MaBangxoa + "'";
                Functions.RunSQL(sql);
                // Cập nhật lại tổng tiền cho hóa đơn bán
                tong = Convert.ToDouble(Functions.GetFieldValues("SELECT TongTien FROM tblPhieuMuon WHERE MaHDBan = N'" + txtMaHDBan.Text + "'"));
                tongmoi = tong - ThanhTienxoa;
                sql = "UPDATE tblPhieuMuon SET TongTien =" + tongmoi + " WHERE MaHDBan = N'" + txtMaHDBan.Text + "'";
                Functions.RunSQL(sql);
                txtTongTien.Text = tongmoi.ToString();
                //lblBangChu.Text = "Bằng chữ: " + Functions.ChuyenSoSangChu(tongmoi.ToString());
                LoadDataGridView();
            }
        }
    }
}
