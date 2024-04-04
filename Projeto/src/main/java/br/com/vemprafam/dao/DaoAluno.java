package br.com.vemprafam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.vemprafam.pojo.Aluno;

public class DaoAluno {

	private String url = "jdbc:hsqldb:hsql://localhost/";
	private String user = "SA";
	private String password = "";
	private Connection connection = null;
	public DaoAluno() {
		super();
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void inserir(Aluno aluno) {
		try {
			String sql = "INSERT INTO ALUNOS VALUES(?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, aluno.getRa());
			pstmt.setString(2, aluno.getNome());
			pstmt.setDate(3,
				new java.sql.Date(aluno.getDataNascimento().getTime()));
			pstmt.setDouble(4, aluno.getRenda());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Aluno> getLista() {
		List<Aluno> result = new ArrayList<Aluno>();
		try {
			String sql="SELECT RA,NOME,DATANASCIMENTO,RENDA FROM ALUNOS";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while( rs.next() ) {
				int ra = rs.getInt(1);
				String nome = rs.getString("NOME");
				Date dataNascimento = rs.getDate(3);
				double renda = rs.getDouble("RENDA");
				Aluno aluno = new Aluno(ra, nome, dataNascimento, renda);
				result.add(aluno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}

	public Aluno buscarPeloRa( int ra ) {
		try {
			String sql=
			"SELECT RA,NOME,DATANASCIMENTO,RENDA FROM ALUNOS WHERE RA=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, ra);
			ResultSet rs = pstmt.executeQuery();
			if( rs.next() ) {

				String nome = rs.getString("NOME");
				Date dataNascimento = rs.getDate(3);
				double renda = rs.getDouble("RENDA");
				Aluno aluno = new Aluno(ra, nome, dataNascimento, renda);
				return aluno;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;
	}

	public void atualizar( Aluno aluno ) {
		try {
			String sql =
			"UPDATE ALUNOS SET nome=?,datanascimento=?,renda=? WHERE RA=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, aluno.getNome());
			pstmt.setDate(2,
				new java.sql.Date(aluno.getDataNascimento().getTime()));
			pstmt.setDouble(3, aluno.getRenda());
			pstmt.setInt(4, aluno.getRa());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public void excluir( Aluno aluno ) {
		try {
			String sql = "DELETE FROM ALUNOS WHERE RA=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, aluno.getRa());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		DaoAluno  dao = new DaoAluno();
		//dao.excluir(new Aluno(1,"aaa",new Date(),1000));
		System.out.println(dao.buscarPeloRa(222));
	}
}











