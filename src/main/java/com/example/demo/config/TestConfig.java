package com.example.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entitys.Categoria;
import com.example.demo.entitys.ItensPedido;
import com.example.demo.entitys.Pagamento;
import com.example.demo.entitys.Pedido;
import com.example.demo.entitys.Produto;
import com.example.demo.entitys.User;
import com.example.demo.entitys.enums.PedidoStatus;
import com.example.demo.repositories.IntensPedidoRepository;
import com.example.demo.repositories.PedidoRepository;
import com.example.demo.repositories.ProdutoRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.categoriaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PedidoRepository Prepositiry;
	
	@Autowired
	private categoriaRepository Crepositiry;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private IntensPedidoRepository itenPedidoRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"),PedidoStatus.PAGO, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.DELIVERED,u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.CANCELADO,u1);
		
		
		
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");
		
		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		repository.saveAll(Arrays.asList(u1,u2));
		Prepositiry.saveAll(Arrays.asList(o1,o2,o3));
		Crepositiry.saveAll(Arrays.asList(cat1,cat2,cat3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);

		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		ItensPedido oi1 = new ItensPedido(o1, p1, 2, p1.getPreco());
		ItensPedido oi2 = new ItensPedido(o1, p3, 1, p3.getPreco());
		ItensPedido oi3 = new ItensPedido(o2, p3, 2, p3.getPreco());
		ItensPedido oi4 = new ItensPedido(o3, p5, 2, p5.getPreco());
		
				
		itenPedidoRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		Pagamento pag1 = new Pagamento(null,Instant.parse("2019-06-20T21:53:07Z"),o1);
		o1.setPagamento(pag1);
		
		Prepositiry.save(o1);
		
	}
	
	
	

}
