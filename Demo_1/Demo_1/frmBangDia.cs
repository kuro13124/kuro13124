using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;
using Demo_1.Class;


namespace Demo_1
{
    
    public partial class frmBangDia : Form
    {
        DataTable tblH;
        public frmBangDia()
        {
            InitializeComponent();
        }

        private void frmBangDia_Load(object sender, EventArgs e)
        {
            //string sql;
            //sql = "SELECT * from tblChatLieu";
            txtMaBang.Enabled = true;
            txtDonGiaBan.Enabled = true;
            btnLuu.Enabled = false;
            btnBoQua.Enabled = false;
            LoadDataGridView();
            //Functions.FillCombo(sql, cboMaChatLieu, "MaChatLieu", "TenChatLieu");
            //cboMaChatLieu.SelectedIndex = -1;
            ResetValues();
        }
        private void LoadDataGridView()
        {
            string sql;
            sql = "SELECT * from tblBang";
            tblH = Functions.GetDataToTable(sql);
            dgvHang.DataSource = tblH;
            dgvHang.Columns[0].HeaderText = "Mã hàng";
            dgvHang.Columns[1].HeaderText = "Tên hàng";
            dgvHang.Columns[2].HeaderText = "Số Lượng Tồn";
            dgvHang.Columns[3].HeaderText = "Giá Nhập";
            dgvHang.Columns[4].HeaderText = "Thể loại";
            dgvHang.Columns[5].HeaderText = "Tác Giả";
            //dgvHang.Columns[6].HeaderText = "Ảnh";
            //dgvHang.Columns[7].HeaderText = "Ghi chú";
            dgvHang.Columns[0].Width = 80;
            dgvHang.Columns[1].Width = 140;
            dgvHang.Columns[2].Width = 80;
            dgvHang.Columns[3].Width = 80;
            dgvHang.Columns[4].Width = 100;
            dgvHang.Columns[5].Width = 100;
            //dgvHang.Columns[6].Width = 200;
            //dgvHang.Columns[7].Width = 300;
            //dgvHang.AllowUserToAddRows = false;
            dgvHang.EditMode = DataGridViewEditMode.EditProgrammatically;
        }
        private void ResetValues()
        {
            txtMaBang.Text = "";
            txtTenBang.Text = "";
            txtSoLuong.Text = "0";          
            txtDonGiaBan.Text = "0";
            txtType.Text = "";
            txtTenTacGia.Text = "";
            txtMaBang.Enabled = false;
            txtSoLuong.Enabled = true;          
            txtDonGiaBan.Enabled = true;
            
        }


        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void dgvHang_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            //string MaChatLieu;
            //string sql;
            if (btnThem.Enabled == false)
            {
                MessageBox.Show("Đang ở chế độ thêm mới!", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                txtMaBang.Focus();
                return;
            }
            if (tblH.Rows.Count == 0)
            {
                MessageBox.Show("Không có dữ liệu!", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            txtMaBang.Text = dgvHang.CurrentRow.Cells["MaBang"].Value.ToString();
            txtTenBang.Text = dgvHang.CurrentRow.Cells["TenBang"].Value.ToString();
            txtSoLuong.Text = dgvHang.CurrentRow.Cells["SoLuong"].Value.ToString();
            txtDonGiaBan.Text = dgvHang.CurrentRow.Cells["DonGiaBan"].Value.ToString();
            txtType.Text = dgvHang.CurrentRow.Cells["Type"].Value.ToString();
            txtTenTacGia.Text = dgvHang.CurrentRow.Cells["TacGia"].Value.ToString();
            btnSua.Enabled = true;
            btnXoa.Enabled = true;
            btnBoQua.Enabled = true;
        }

        private void btnThem_Click(object sender, EventArgs e)
        {
            btnSua.Enabled = false;
            btnXoa.Enabled = false;
            btnBoQua.Enabled = true;
            btnLuu.Enabled = true;
            btnThem.Enabled = false;
            ResetValues();
            txtMaBang.Enabled = true;
            txtMaBang.Focus();
            txtSoLuong.Enabled = true;
            txtDonGiaBan.Enabled = true;
            txtType.Enabled = true;
            txtTenTacGia.Enabled = true;

        }

        private void btnLuu_Click(object sender, EventArgs e)
        {
            string sql;
            if (txtMaBang.Text.Trim().Length == 0)
            {
                MessageBox.Show("Bạn phải nhập mã hàng", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                txtMaBang.Focus();
                return;
            }
            if (txtTenBang.Text.Trim().Length == 0)
            {
                MessageBox.Show("Bạn phải nhập tên hàng", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                txtTenBang.Focus();
                return;
            }
            /*if (cboMaChatLieu.Text.Trim().Length == 0)
            {
                MessageBox.Show("Bạn phải nhập chất liệu", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                cboMaChatLieu.Focus();
                return;
            }*/
            /*if (txtAnh.Text.Trim().Length == 0)
            {
                MessageBox.Show("Bạn phải chọn ảnh minh hoạ cho hàng", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                btnOpen.Focus();
                return;
            }*/
            sql = "SELECT MaBang FROM tblBang WHERE MaBang=N'" + txtMaBang.Text.Trim() + "'";
            if (Functions.CheckKey(sql))
            {
                MessageBox.Show("Mã hàng này đã tồn tại, bạn phải chọn mã hàng khác", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                txtMaBang.Focus();
                return;
            }
            sql = "INSERT INTO tblBang(MaBang,TenBang,SoLuong, DonGiaBan,Type,TacGia) VALUES(N'"
                + txtMaBang.Text.Trim() + "',N'" + txtTenBang.Text.Trim() +
                /*"',N'" + cboMaChatLieu.SelectedValue.ToString() +*/
                "'," + txtSoLuong.Text.Trim() + /*"," + txtDonGiaNhap.Text +*/
                "," + txtDonGiaBan.Text + ",'" + txtType.Text.Trim() + "',N'" + txtTenTacGia.Text.Trim() + "')";

            Functions.RunSQL(sql);
            LoadDataGridView();
            //ResetValues();
            btnXoa.Enabled = true;
            btnThem.Enabled = true;
            btnSua.Enabled = true;
            btnBoQua.Enabled = false;
            btnLuu.Enabled = false;
            txtMaBang.Enabled = true;
        }

        private void btnSua_Click(object sender, EventArgs e)
        {
            string sql;
            if (tblH.Rows.Count == 0)
            {
                MessageBox.Show("Không còn dữ liệu", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if (txtMaBang.Text == "")
            {
                MessageBox.Show("Bạn chưa chọn bản ghi nào", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                txtMaBang.Focus();
                return;
            }
            if (txtTenBang.Text.Trim().Length == 0)
            {
                MessageBox.Show("Bạn phải nhập tên hàng", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                txtTenBang.Focus();
                return;
            }
            /*if (cboMaChatLieu.Text.Trim().Length == 0)
            {
                MessageBox.Show("Bạn phải nhập chất liệu", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                cboMaChatLieu.Focus();
                return;
            }
            if (txtAnh.Text.Trim().Length == 0)
            {
                MessageBox.Show("Bạn phải ảnh minh hoạ cho hàng", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                txtAnh.Focus();
                return;
            }*/
            sql = "UPDATE tblBang SET TenBang=N'" + txtTenBang.Text.Trim().ToString() +
                /*"',MaChatLieu=N'" + cboMaChatLieu.SelectedValue.ToString() +*/
                "',SoLuong="+txtSoLuong.Text + ",DonGiaBan ="+ txtDonGiaBan.Text +
                ",Type=N'" + txtType.Text + "',TacGia=N'" + txtTenTacGia.Text +"' WHERE MaBang=N'" + txtMaBang.Text + "'";
            Functions.RunSQL(sql);
            LoadDataGridView();
            ResetValues();
            btnBoQua.Enabled = false;
        }

        private void btnBoQua_Click(object sender, EventArgs e)
        {
            ResetValues();
            btnXoa.Enabled = true;
            btnSua.Enabled = true;
            btnThem.Enabled = true;
            btnBoQua.Enabled = false;
            btnLuu.Enabled = false;
            txtMaBang.Enabled = false;
        }

        private void btnXoa_Click(object sender, EventArgs e)
        {
            string sql;
            if (tblH.Rows.Count == 0)
            {
                MessageBox.Show("Không còn dữ liệu!", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if (txtMaBang.Text == "")
            {
                MessageBox.Show("Bạn chưa chọn bản ghi nào", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if (MessageBox.Show("Bạn có muốn xoá bản ghi này không?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
            {
                sql = "DELETE tblBang WHERE MaBang=N'" + txtMaBang.Text + "'";
                Functions.RunSqlDel(sql);
                LoadDataGridView();
                ResetValues();
            }
        }

        private void btnTimKiem_Click(object sender, EventArgs e)
        {
            string sql;
            if ((txtMaBang.Text == "")&& (txtTenBang.Text == "")&&(txtType.Text == "") && (txtTenTacGia.Text == ""))
            {
                MessageBox.Show("Bạn hãy nhập điều kiện tìm kiếm", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            sql = "SELECT * from tblBang WHERE 1=1";
            if (txtMaBang.Text != "")
                sql += " AND MaBang LIKE N'%" + txtMaBang.Text + "%'";
            if (txtTenBang.Text != "")
                sql += " AND TenBang LIKE N'%" + txtTenBang.Text + "%'";
            if (txtType.Text != "")
                sql += " AND Type LIKE N'%" + txtType.Text + "%'";
            if (txtTenTacGia.Text != "")
                sql += " AND TacGia LIKE N'%" + txtTenTacGia.Text + "%'";
            //if (cboMaChatLieu.Text != "")
            //sql += " AND MaChatLieu LIKE N'%" + cboMaChatLieu.SelectedValue + "%'";
            tblH = Functions.GetDataToTable(sql);
            if (tblH.Rows.Count == 0)
                MessageBox.Show("Không có bản ghi thoả mãn điều kiện tìm kiếm!", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
            else MessageBox.Show("Có " + tblH.Rows.Count + "  bản ghi thoả mãn điều kiện!", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
            dgvHang.DataSource = tblH;
            ResetValues();
        }
    }
}
