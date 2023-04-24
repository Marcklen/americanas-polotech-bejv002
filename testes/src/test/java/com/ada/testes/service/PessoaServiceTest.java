package com.ada.testes.service;

import com.ada.testes.dto.in.PessoaCreateDTO;
import com.ada.testes.dto.out.PessoaDTO;
import com.ada.testes.entity.PessoaEntity;
import com.ada.testes.exception.RegraDeNegocioException;
import com.ada.testes.repository.PessoaRepository;
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

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PessoaServiceTest {

    @InjectMocks
    private PessoaService pessoaService;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private PessoaRepository pessoaRepository;

    @Before
    public void setUp(){
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ReflectionTestUtils.setField(pessoaService, "objectMapper", objectMapper);
    }

    // deve criar com sucesso
    @Test
    public void deveCriarComSucesso() {
        // SETUP
        PessoaCreateDTO pessoaCreateDTO = getPessoaCreateDTOMock();
        PessoaEntity pessoaMock = getPessoaEntityMock();
        when(pessoaRepository.save(any())).thenReturn(pessoaMock);
        // ACT
        PessoaDTO pessoaDTO = pessoaService.cadastrarPessoa(pessoaCreateDTO);
        // ASSERT
        assertNotNull(pessoaDTO);
        assertEquals(pessoaDTO.getId_pessoa(), pessoaMock.getId_pessoa());
    }

    // deve editar com sucesso
    @Test
    public void deveEditarComSucesso() throws RegraDeNegocioException {
        // SETUP
        Integer id = 1;
        PessoaCreateDTO pessoaCreateDTO = getPessoaCreateDTOMock();
        PessoaEntity pessoaMock = getPessoaEntityMock();
        when(pessoaRepository.findById(anyInt())).thenReturn(Optional.of(pessoaMock));
        when(pessoaRepository.save(any())).thenReturn(pessoaMock);
        // ACT
        PessoaDTO pessoaDTO = pessoaService.editarPessoa(id, pessoaCreateDTO);
        // ASSERT
        assertNotNull(pessoaDTO);
        assertEquals(pessoaDTO.getId_pessoa(), pessoaMock.getId_pessoa());
    }
    // dele listar com sucesso
    @Test
    public void deveListarComSucesso() {
        // SETUP
        List<PessoaEntity> lista = List.of(getPessoaEntityMock(), getPessoaEntityMock());
        when(pessoaRepository.findAll()).thenReturn(lista);
        // ACT
        List<PessoaDTO> listaDTO = pessoaService.listarPessoas();
        // ASSERT
        assertNotNull(listaDTO);
        assertEquals(2, listaDTO.size());
    }

    @Test
    public void deveRetornarAoBuscarPorCPFComSucesso() {
        // SETUP
        when(pessoaRepository.findByCpf(anyString())).thenReturn(Optional.of(getPessoaEntityMock()));
        // ACT
        Optional<PessoaDTO> pessoaDTO = pessoaService.buscarPorCPF("12345678901");
        // ASSERT
        assertNotNull(pessoaDTO);
        assertEquals("12345678901", pessoaDTO.get().getCpf());
    }

    @Test
    public void deveRetornarAoBuscarPorEmailComSucesso() {
        // SETUP
        when(pessoaRepository.findByEmail(anyString())).thenReturn(Optional.of(getPessoaEntityMock()));
        // ACT
        Optional<PessoaDTO> pessoaDTO = pessoaService.buscarPorEmail("fulano@gmail.com");
        // ASSERT
        assertNotNull(pessoaDTO);
        assertEquals("fulano@gmail.com", pessoaDTO.get().getEmail());
    }

    @Test(expected = RegraDeNegocioException.class)
    public void deveLancarExcecaoAoNaoAcharPorID() throws RegraDeNegocioException {
        // SETUP
        Integer id = 1;
        PessoaCreateDTO pessoaCreateDTO = getPessoaCreateDTOMock();
        when(pessoaRepository.findById(anyInt())).thenReturn(Optional.empty());
        // ACT
        pessoaService.editarPessoa(id, pessoaCreateDTO);
    }

    public static PessoaEntity getPessoaEntityMock() {
        PessoaEntity pessoaMock = new PessoaEntity();
        pessoaMock.setId_pessoa(1);
        pessoaMock.setNome("fulano");
        pessoaMock.setCpf("12345678901");
        pessoaMock.setEmail("fulano@gmail.com");
        pessoaMock.setTelefone("123456789");
        pessoaMock.setSaldo(1000.00);
        return pessoaMock;
    }

    public static PessoaCreateDTO getPessoaCreateDTOMock() {
        PessoaCreateDTO pessoaCreateDTO = new PessoaCreateDTO();
        pessoaCreateDTO.setNome("fulano");
        pessoaCreateDTO.setCpf("12345678901");
        pessoaCreateDTO.setEmail("fulano@gmail.com");
        pessoaCreateDTO.setTelefone("123456789");
        pessoaCreateDTO.setSaldo(1000.00);
        return pessoaCreateDTO;
    }
}
