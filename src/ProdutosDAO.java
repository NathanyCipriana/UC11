
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;        


public class ProdutosDAO {
    private conectaDAO conexao;
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public ProdutosDAO(){
        this.conexao = new conectaDAO();
        this.conn = this.conexao.getConexao();
    }
    
    public void cadastrarProduto (ProdutosDTO produto){
       
        
        String sql = "INSERT INTO produto (nome, valor, status) VALUES (?, ?, ?)";
        try {
             PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setInt(2, produto.getValor());
            ps.setString(3, produto.getStatus());
            
            ps.executeUpdate();
            
            System.out.println("Produto cadastrado com sucesso!");
            
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }
    
    
    public ArrayList<ProdutosDTO> listarProdutos() {
    
        String sql = "SELECT id, nome, valor, status FROM produto";
        
        try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));
                
                listagem.add(produto);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        } 
        
        return listagem;
    }    
    
    public void venderProduto(int idProduto) {
        String sql = "UPDATE produto SET status = 'Vendido' WHERE id = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, idProduto);
            System.out.println("Produto vendido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao vender produto: " + e.getMessage());
        } 
    }
    
    public ArrayList<ProdutosDTO> listarProdutosVendidos() {
        ArrayList<ProdutosDTO> produtosVendidos = new ArrayList<>();

        String sql = "SELECT id, nome, valor, status FROM produto WHERE status = 'Vendido'";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));

                produtosVendidos.add(produto);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos vendidos: " + e.getMessage());
        } 
    
        return produtosVendidos;
    }
    
}

 


