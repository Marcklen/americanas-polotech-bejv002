package com.ada.testes.service;

import com.ada.testes.dto.out.LivroDTO;
import com.ada.testes.dto.out.TransacaoDTO;
import com.ada.testes.entity.LivroEntity;
import com.ada.testes.entity.PessoaEntity;
import com.ada.testes.entity.TransacaoEntity;
import com.ada.testes.exception.RegraDeNegocioException;
import com.ada.testes.repository.TransacaoRepository;
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

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static com.ada.testes.service.LivroServiceTest.getLivroCreateDTOMock;
import static com.ada.testes.service.LivroServiceTest.getLivroEntityMock;
import static com.ada.testes.service.PessoaServiceTest.getPessoaEntityMock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TransacaoServiceTest {

    @InjectMocks
    private TransacaoService transacaoService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private TransacaoRepository transacaoRepository;

    @Mock
    private LivroService livroService;
    @Mock
    private PessoaService pessoaService;

    @Before
    public void setUp() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ReflectionTestUtils.setField(transacaoService, "objectMapper", objectMapper);
        ReflectionTestUtils.setField(livroService, "objectMapper", objectMapper);
        ReflectionTestUtils.setField(pessoaService, "objectMapper", objectMapper);
    }

    @Test
    public void deveListarTransacoesComSucesso() throws RegraDeNegocioException {
        // SETUP
//        List<TransacaoEntity> transacaoMock = List.of(
//                TransacaoEntity.builder()
//                        .id_transacao(1)
//                        .livros(Set.of(LivroEntity.builder().id_livro(1).build()))
//                        .pessoa(getPessoaEntityMock())
//                        .build(),
//                TransacaoEntity.builder()
//                        .id_transacao(2)
//                        .livros(Set.of(LivroEntity.builder().id_livro(2).build()))
//                        .pessoa(getPessoaEntityMock())
//                        .build()
//        );
//        when(transacaoRepository.findAll()).thenReturn(transacaoMock);
//        // ACT
//        List<TransacaoDTO> transacaoDTO = transacaoService.listar();
//        // ASSERT
//        assertNotNull(transacaoDTO);
//        assertEquals(2, transacaoMock.size());
    }

    @Test
    public void deveCadastrarTransacaoComSucesso() throws RegraDeNegocioException {
        // SETUP
//        PessoaEntity pessoaMock = getPessoaEntityMock();
//        when(pessoaService.buscarPessoaPorId(anyInt())).thenReturn(pessoaMock);
//
//        Set<LivroEntity> livrosMocks = (Set<LivroEntity>) getLivroEntityMock();
//        when(livroService.listarLivros().stream().map(
//                livroEntity -> LivroDTO.builder()
//                        .id_livro(livroEntity.getId_livro())
//                        .build()
//                )).thenReturn((Stream<LivroDTO>) getLivroCreateDTOMock());
//
//        // ACT
//        when(transacaoRepository.save(any())).thenReturn(this);
//        // ASSERT
//        assertNotNull(getTransacaoMock());
    }

    @NotNull
    private static TransacaoEntity getTransacaoMock() {
//        TransacaoEntity transacaoMock =
//                TransacaoEntity.builder()
//                .id_transacao(1)
//                .livros(Set.of(LivroEntity.builder().id_livro(1).build()))
//                .pessoa(getPessoaEntityMock())
//                .build();
        return null;
    }
}