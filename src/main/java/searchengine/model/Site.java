package searchengine.model;

import lombok.Data;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Data
@Entity
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT", nullable = false)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('INDEXING', 'INDEXED', 'FAILED')", nullable = false)
    private Status status;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private Date status_time;

    @Column(columnDefinition = "TEXT")
    private String last_error;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String url;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String name;

//    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Page> pages;

//    id INT NOT NULL AUTO_INCREMENT;
//    status ENUM('INDEXING', 'INDEXED', 'FAILED') NOT NULL — текущий статус полной индексации сайта, отражающий готовность поискового движка осуществлять поиск по сайту — индексация или переиндексация в процессе, сайт полностью проиндексирован (готов к поиску) либо его не удалось проиндексировать (сайт не готов к поиску и не будет до устранения ошибок и перезапуска индексации);
//    status_time DATETIME NOT NULL — дата и время статуса (в случае статуса INDEXING дата и время должны обновляться регулярно при добавлении каждой новой страницы в индекс);
//    last_error TEXT — текст ошибки индексации или NULL, если её не было;
//    url VARCHAR(255) NOT NULL — адрес главной страницы сайта;
//    name VARCHAR(255) NOT NULL — имя сайта.

}
