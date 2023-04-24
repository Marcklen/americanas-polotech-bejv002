package com.ada.testes.service;

import com.ada.testes.dto.in.LivroCreateDTO;
import com.ada.testes.dto.out.LivroDTO;
import com.ada.testes.entity.LivroEntity;
import com.ada.testes.exception.RegraDeNegocioException;
import com.ada.testes.repository.LivroRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LivroServiceTest {

    @InjectMocks
    private LivroService livroService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private LivroRepository livroRepository;

    @Before
    public void setUp() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ReflectionTestUtils.setField(livroService, "objectMapper", objectMapper);
    }

    @Test
    public void deveCriarLivroComSucesso() {
        // SETUP
        LivroCreateDTO livroCreateDTO = getLivroCreateDTOMock();
        LivroEntity livroMock = getLivroEntityMock();
        when(livroRepository.save(any())).thenReturn(livroMock);
        // ACT
        LivroDTO livroDTO = livroService.cadastrarLivro(livroCreateDTO);
        // ASSERT
        assertNotNull(livroMock);
        assertEquals(livroDTO.getId_livro(), livroMock.getId_livro());
    }

    @Test
    public void deveEditarLivroComSucesso() throws RegraDeNegocioException {
        // SETUP
        Integer id = 1;
        LivroCreateDTO livroCreateDTO = getLivroCreateDTOMock();
        LivroEntity livroMock = getLivroEntityMock();
        when(livroRepository.findById(any())).thenReturn(Optional.of(livroMock));
//        when(livroRepository.save(any())).thenReturn(livroMock);
        // ACT
        LivroDTO livroDTO = livroService.editarLivro(id, livroCreateDTO);
        // ASSERT
        assertNotNull(livroMock);
        assertEquals(livroDTO.getId_livro(), livroMock.getId_livro());
    }

    @Test
    public void deveDeletarLivroComSucesso() throws RegraDeNegocioException {
        // SETUP
        LivroEntity livroMock = getLivroEntityMock();
        when(livroRepository.findById(any())).thenReturn(Optional.of(livroMock));
        // ACT
        livroService.excluirLivro(1);
        // ASSERT
        verify(livroRepository, times(1)).delete(livroMock);
    }

    @Test
    public void deveListarLivrosComSucesso() {
        // SETUP
        List<LivroEntity> livroMock = List.of(getLivroEntityMock(), getLivroEntityMock());
        when(livroRepository.findAll()).thenReturn(livroMock);
        // ACT
        List<LivroDTO> livroDTO = livroService.listarLivros();
        // ASSERT
        assertNotNull(livroDTO);
        assertEquals(2, livroMock.size());
    }

    public static LivroEntity getLivroEntityMock() {
        LivroEntity livroEntity = new LivroEntity();
        livroEntity.setId_livro(1);
        livroEntity.setNome("Livro 1");
        livroEntity.setAutor("Autor 1");
        livroEntity.setEdicao("Edição 1");
        livroEntity.setPreco(90.00);
        livroEntity.setQuantidade(10);
        return livroEntity;
    }

    public static LivroCreateDTO getLivroCreateDTOMock() {
        LivroCreateDTO livroCreateDTO = new LivroCreateDTO();
        livroCreateDTO.setNome("Livro 1");
        livroCreateDTO.setAutor("Autor 1");
        livroCreateDTO.setEdicao("Edição 1");
        livroCreateDTO.setPreco(90.00);
        livroCreateDTO.setQuantidade(10);
        return livroCreateDTO;
    }
}
