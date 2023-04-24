package com.ada.testes.controller;

import com.ada.testes.dto.in.LivroCreateDTO;
import com.ada.testes.dto.out.LivroDTO;
import com.ada.testes.service.LivroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.ada.testes.service.LivroServiceTest.getLivroCreateDTOMock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LivroController.class)
public class LivroControllerTest {

    @MockBean
    private LivroService livroService;

    private final String baseUri = "/api/v1/livros";

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveCadastrarLivroComSucesso() throws Exception {
        LivroCreateDTO livroCreateDTO = getLivroCreateDTOMock();
        LivroDTO livroDTO = getLivroDTOMock();

        when(livroService.cadastrarLivro(any(LivroCreateDTO.class))).thenReturn(livroDTO);

        mockMvc.perform(post(baseUri)
                        .content(objectMapper.writeValueAsString(livroCreateDTO))
                        .contentType("application/json")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void deveEditarLivroComSucesso() throws Exception {
        LivroCreateDTO livroCreateDTO = getLivroCreateDTOMock();
        Integer idLivro = 1;
        LivroDTO livroDTO = getLivroDTOMock();

        when(livroService.editarLivro(any(Integer.class), any(LivroCreateDTO.class)))
                .thenReturn(livroDTO);

        mockMvc.perform(put(baseUri + "/" + idLivro)
                        .content(objectMapper.writeValueAsString(livroCreateDTO))
                        .contentType("application/json")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deveListarLivrosComSucesso() throws Exception {
        mockMvc.perform(get(baseUri)
                        .contentType("application/json")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deveDeletarLivroComSucesso() throws Exception {
        Integer idLivro = 1;

        livroService.excluirLivro(idLivro);

        mockMvc.perform(delete(baseUri + "/" + idLivro)
                        .contentType("application/json")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    private LivroDTO getLivroDTOMock() {
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId_livro(1);
        livroDTO.setNome("Livro 1");
        livroDTO.setAutor("Autor 1");
        livroDTO.setEdicao("1");
        livroDTO.setPreco(100d);
        livroDTO.setQuantidade(10);
        return livroDTO;
    }
}
