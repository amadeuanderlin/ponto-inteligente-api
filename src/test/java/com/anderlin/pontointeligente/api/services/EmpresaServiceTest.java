package com.anderlin.pontointeligente.api.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.anderlin.pontointeligente.api.entities.Empresa;
import com.anderlin.pontointeligente.api.repositories.EmpresaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaServiceTest {

	/**
	 * Permite utilizar objeto falso, sem ter que criar uma instância verdadeira
	 * Por isso utilizado a anotação @MockBean ao invés de @Autowired
	 * Como os testes no repositório de Empresa passou, podemos usar essa estratégia
	 */
	@MockBean
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	private static final String CNPJ = "51463645000100";
	
	@Before
	public void setUp() throws Exception {
		//Mock para o método findByCnpj
		BDDMockito.given(this.empresaRepository.findByCnpj(Mockito.anyString())).willReturn(new Empresa());
		//Mock para o método save
		BDDMockito.given(this.empresaRepository.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
	}
	
	@Test
	public void testBuscarEmpresaPorCnpj() {
		Optional<Empresa> empresa = this.empresaService.buscarPorCnpj(CNPJ);
		
		assertTrue(empresa.isPresent());
	}
	
	@Test
	public void testPersistiEmpresa() {
		Empresa empresa = this.empresaService.persistir(new Empresa());
		
		assertNotNull(empresa);
	}
}
