package test.pkgs;

import com.pkgs.entity.rookie.RookieEntity;
import com.pkgs.service.rookie.RookieService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * TODO:
 *
 * @author cs12110 create at: 2019/3/3 22:12
 * Since: 1.0.0
 */
public class SpringTestImpl extends AbstractSpringTest {

    @Autowired
    private RookieService rookieService;

    @Override
    public void test() {
        RookieEntity entity = rookieService.queryById(1);

        System.out.println(entity);
    }
}
