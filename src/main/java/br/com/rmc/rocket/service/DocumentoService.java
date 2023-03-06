package br.com.rmc.rocket.service;

import br.com.rmc.rocket.entity.Documento;
import br.com.rmc.rocket.entity.Usuario;
import br.com.rmc.rocket.repository.DocumentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocumentoService {

    private final DocumentoRepository documentoRepository;

    public DocumentoService(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    @Transactional
    public void salvarDocumentos(List<MultipartFile> arquivos, Usuario usuario) {
        List<Documento> documentosList = arquivos.stream().map(arquivo -> {
            try {
                return converterParaDocumento(arquivo, usuario);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).toList();

        documentoRepository.saveAll(documentosList);
    }

    public Documento converterParaDocumento(MultipartFile arquivo, Usuario usuario) throws IOException {
        Documento documento = new Documento();
        documento.setUsuario(usuario);
        documento.setConteudo(arquivo.getBytes());
        documento.setNome(arquivo.getOriginalFilename());
        documento.setDataCriacao(LocalDateTime.now());

        return documento;
    }

}