package com.ada.testes.controller;


import com.ada.testes.dto.in.PessoaCreateDTO;
import com.ada.testes.dto.out.PessoaDTO;
import com.ada.testes.service.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.ada.testes.service.PessoaServiceTest.getPessoaCreateDTOMock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PessoaController.class)
public class PessoaControllerTest {

    @MockBean
    private PessoaService pessoaService;
    private final String baseUri = "/api/v1/pessoas";
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveCadastrarComSucesso() throws Exception {
        PessoaCreateDTO requisicao = getPessoaCreateDTOMock();
        PessoaDTO pessoaDTO = getPessoaDTOMock();

        when(pessoaService.cadastrarPessoa(any(PessoaCreateDTO.class))).thenReturn(pessoaDTO);

        mockMvc.perform(post(baseUri)
                        .content(objectMapper.writeValueAsString(requisicao))
                        .contentType("application/json")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void deveEditarComSucesso() throws Exception {
        PessoaCreateDTO requisicao = getPessoaCreateDTOMock();

        Integer idPessoa = 1;
        PessoaDTO pessoaDTO = getPessoaDTOMock();

        when(pessoaService.editarPessoa(any(Integer.class), any(PessoaCreateDTO.class))).thenReturn(pessoaDTO);

        mockMvc.perform(put(baseUri + "/" + idPessoa)
                        .content(objectMapper.writeValueAsString(requisicao))
                        .contentType("application/json")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private PessoaDTO getPessoaDTOMock() {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome("fulano");
        pessoaDTO.setCpf("12345678901");
        pessoaDTO.setEmail("fulano@gmail.com");
        pessoaDTO.setTelefone("123456789");
        pessoaDTO.setSaldo(1000.00);
        return pessoaDTO;
    }

    @Test
    public void deveListarComSucesso() throws Exception {
        mockMvc.perform(get(baseUri)
                        .contentType("application/json")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
