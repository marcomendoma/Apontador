package com.apontador.CrudApontador;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.apontador.CrudApontador.controller.LocalidadeController;
import com.apontador.CrudApontador.domain.Localidade;
import com.apontador.CrudApontador.service.LocalidadeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { LocalidadeController.class })
public class ApontadorTeste {
	private static final ObjectMapper om = new ObjectMapper();

    private MockMvc mockMvc;
    
    private Localidade localidade;
	
	@Autowired
	LocalidadeController localidadeController;
	
	@MockBean
	private LocalidadeService localidadeService;
	
	@Before
	public void setUp() {
	    mockMvc = MockMvcBuilders
	    			.standaloneSetup(localidadeController)
	    			.build();
	    
	    localidade.setNome("Centro Esportivo Banespa");
	    localidade.setEndereco("Av. Braz Cubas, 1510");
	    localidade.setFone("19 997393471");
	    
	}
	
	@Test
    public void listar() throws Exception {
		List<Localidade> localidades = Arrays.asList(
					new Localidade("Grajau Center", "69 99936-9428", "Rua Tarsila, 549"),
					new Localidade("Akalan Deposito de Mat. P/ construção", "87 98194-8806", "Rua Padre Martinêz, 358"),
					new Localidade("EMJN Desenvolvimento de Sistemas", "91 98116-7380", "Rua Maria das Neves Rocha 749")
				);
		
		when(localidadeService.list()).thenReturn(localidades);
		 
		ResultActions response = mockMvc.perform(post("/salvar")
		        .content(om.writeValueAsString(localidade))
		        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON));
		
		response
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
	        .andExpect(jsonPath("$[0].id", is(1)))
	        .andExpect(jsonPath("$[0].nome", is("Grajau Center")))
	        .andExpect(jsonPath("$[0].fone", is("69 99936-9428")))
	        .andExpect(jsonPath("$[0].endereco", is("Rua Tarsila, 549")))
	        .andExpect(jsonPath("$[1].id", is(2)))
	        .andExpect(jsonPath("$[1].nome", is("Akalan Deposito de Mat. P/ construção")))
	        .andExpect(jsonPath("$[1].fone", is("87 98194-8806")))
	        .andExpect(jsonPath("$[1].endereco", is("Rua Padre Martinêz, 358")))
	        .andExpect(jsonPath("$[2].id", is(3)))
	        .andExpect(jsonPath("$[2].nome", is("EMJN Desenvolvimento de Sistemas")))
	        .andExpect(jsonPath("$[2].fone", is( "91 98116-7380")))
	        .andExpect(jsonPath("$[2].endereco", is( "Rua Maria das Neves Rocha 749")));
		
		verify(localidadeService, times(1)).list();
    }
	
	@Test
    public void salvar() throws Exception {
		Localidade localidade = new Localidade("Pesqueiro José de Freitas", "21 996290416", "Aguas Secas de Lindoia, 1200");
		
		when(localidadeService.save(any(Localidade.class))).thenReturn(localidade);
		 
		ResultActions response = mockMvc.perform(post("/salvar")
		        .content(om.writeValueAsString(localidade))
		        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON));
		
		response
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
	        .andExpect(jsonPath("$[0].nome", is("Pesqueiro José de Freitas")))
	        .andExpect(jsonPath("$[0].fone", is("21 996290416")))
	        .andExpect(jsonPath("$[0].endereco", is("Aguas Secas de Lindoia, 1200")));
        
        verify(localidadeService, times(1)).save(any(Localidade.class));
    }
	
	@Test
    public void localidadeNotFound_404() throws Exception {
		
		Localidade localidade = new Localidade("Pesqueiro José Dantas", "21 996290416", "Aguas Secas de Lindoia, 1200");
		
        mockMvc.perform(post("/consultar")
	        .content(om.writeValueAsString(localidade))
	        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
    }
	
	@Test
    public void localiadeDelete() throws Exception {

        doNothing().when(localidadeService).delete(1L);

        mockMvc.perform(delete("/1"))
                .andExpect(status().isOk());

        verify(localidadeService, times(1)).delete(1L);
    }
}
