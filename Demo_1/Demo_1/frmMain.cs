using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Demo_1
{
    public partial class frmMain : Form
    {
        public frmMain()
        {
            InitializeComponent();
        }

        private void frmmain_Load(object sender, EventArgs e)
        {
            Class.Functions.Connect(); //Mở kết nối
        }

        private void mnuThoat_Click(object sender, EventArgs e)
        {
            Class.Functions.Disconnect(); //Đóng kết nối
            Application.Exit(); //Thoát
        }

        private void hoaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmHoaDonBan frmHDB = new frmHoaDonBan(); //Khởi tạo đối tượng
            frmHDB.Show(); //Hiển thị
        }

        private void băngĐiaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmBangDia frmBD = new frmBangDia();
            frmBD.Show();
        }

        private void khachHangToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmKhachHang frmKH = new frmKhachHang();
            frmKH.Show();
        }
    }
}
