package controlador;
    import java.sql.Connection ;
    import java.sql.DriverManager ;
    import java.sql.SQLException ;

public  class Conexion {

        private Connection conn;
        private String driver = "com.mysql.cj.jdbc.Driver";
        private String user = "custom";
        private String password = "sena1234567890";
        private String baseDatos = "mydb";
        private String url = "jdbc:mysql://localhost:3306/" + baseDatos
                + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
        public Conexion() {
            conn = null;
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
                if (conn == null) {
                    System.out.println("No se estableció la conexión" + "\n" + url);
                } else {
                    System.out.println("Conexión Establecida");
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }

        public Connection getConn() {
            return conn;
        }

        public void CerrarConexion() throws SQLException {
            if (conn != null) {
                conn.close();
            }
        }
    }
