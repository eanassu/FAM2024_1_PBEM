package br.com.vemprafam.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vemprafam.dao.DaoAluno;
import br.com.vemprafam.pojo.Aluno;

public class LogicaListar implements Logica {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		DaoAluno dao = new DaoAluno();
		List<Aluno> alunos = dao.getLista();
		request.setAttribute("alunos", alunos);
		return "tabelaTaglib.jsp";
	}

}
