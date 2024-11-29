package com.autobots.automanager;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@SpringBootApplication
public class AutomanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomanagerApplication.class, args);
	}

	@Component
	public static class Runner implements ApplicationRunner {
		@Autowired
		public ClienteRepositorio repositorio;

		@Override
		public void run(ApplicationArguments args) throws Exception {
			Calendar calendario = Calendar.getInstance();
			calendario.set(2002, 05, 15);

			Cliente cliente = new Cliente();
			cliente.setNome("Mariana Izumi Kuroshima da Silva");
			cliente.setDataCadastro(Calendar.getInstance().getTime());
			cliente.setDataNascimento(calendario.getTime());
			cliente.setNomeSocial("Mariana Izumi");
			
			Telefone telefone = new Telefone();
			telefone.setDdd("11");
			telefone.setNumero("991234576");
			cliente.getTelefones().add(telefone);
			
			Endereco endereco = new Endereco();
			endereco.setEstado("Meu Estado");
			endereco.setCidade("Minha Cidade");
			endereco.setBairro("Meu bairro");
			endereco.setRua("Avenida da Mariana");
			endereco.setNumero("22222");
			endereco.setCodigoPostal("22021001");
			endereco.setInformacoesAdicionais("Ponto de referência");
			cliente.setEndereco(endereco);
			
			Documento rg = new Documento();
			rg.setTipo("RG");
			rg.setNumero("222222-X");
			
			Documento cpf = new Documento();
			cpf.setTipo("CPF");
			cpf.setNumero("00000000001");
			
			cliente.getDocumentos().add(rg);
			cliente.getDocumentos().add(cpf);
			
			repositorio.save(cliente);
		}
	}

}
