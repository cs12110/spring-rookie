package test.pkgs;

import com.pkgs.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/1 14:22
 * <p>
 * since: 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public abstract class AbstractSpringTest {

    @Test
    public abstract void test();
}
