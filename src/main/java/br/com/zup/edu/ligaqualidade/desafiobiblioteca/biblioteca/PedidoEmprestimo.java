package br.com.zup.edu.ligaqualidade.desafiobiblioteca.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.DadosDevolucao;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.DadosEmprestimo;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.EmprestimoConcedido;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosLivro;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosUsuario;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoUsuario;

public class PedidoEmprestimo {

	DadosExemplar dadosExemplar;
	DadosUsuario dadosUsuario;
	DadosEmprestimo dadosEmprestimo;
	DadosDevolucao dadosDevolucao;

	public boolean UsuarioPadrao(DadosUsuario dadosUsuario) {
		if ((dadosUsuario.padrao.PADRAO != null)
				&& (dadosUsuario.padrao.PADRAO.equals(TipoUsuario.PADRAO.toString()))) {
			return true;
		}
		return false;
	}

	public boolean UsuarioPesquisador(DadosUsuario dadosUsuario) {
		if ((dadosUsuario.padrao.PESQUISADOR != null)
				&& (dadosUsuario.padrao.PESQUISADOR.equals(TipoUsuario.PESQUISADOR.toString()))) {
			return true;
		}
		return false;
	}

	public void solicitacaoEmprestimo(
            Set<DadosLivro> livros, Set<DadosExemplar> exemplares, Set<DadosUsuario> usuarios,
			Set<DadosEmprestimo> emprestimos, Set<DadosDevolucao> devolucoes,
			LocalDate dataParaSerConsideradaNaExpiracao) {
		
		for (DadosUsuario dadosUsuario : usuarios) {
			
			if (UsuarioPadrao(dadosUsuario)) {
				
				List<EmprestimoConcedido> listEmprestimos = new ArrayList();
				for(DadosExemplar dadosExemplar : exemplares) {
					if(dadosExemplar.tipo.LIVRE.equals(TipoExemplar.LIVRE.toString())
							) {
				EmprestimoConcedido possivelEmprestimoConcedido = 
						new EmprestimoConcedido(dadosUsuario.idUsuario, 
								dadosExemplar.idExemplar, dataParaSerConsideradaNaExpiracao);
				listEmprestimos.add(possivelEmprestimoConcedido);
					}
				}
			}
			
			if(UsuarioPesquisador(dadosUsuario)) {
				
			}
		}
	}

}
