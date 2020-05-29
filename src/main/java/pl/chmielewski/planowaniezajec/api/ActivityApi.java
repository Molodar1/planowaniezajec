package pl.chmielewski.planowaniezajec.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@Transactional
@CrossOrigin
public class ActivityApi {
}
