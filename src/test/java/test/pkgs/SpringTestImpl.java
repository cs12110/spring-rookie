package test.pkgs;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pkgs.entity.rookie.RookieEntity;
import com.pkgs.mapper.rookie.RookieMapper;
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

    @Autowired
    private RookieMapper rookieMapper;

    @Override
    public void test() {


        for (int index = 0; index < 10; index++) {
            RookieEntity entity = new RookieEntity();
            entity.setId(index);
            entity.setName("r" + index);
            rookieMapper.insert(entity);
        }

        RookieEntity entity = rookieService.queryById(1);

        System.out.println(entity);

        Page<RookieEntity> page = new Page<>(0, 10);
        Wrapper<RookieEntity> wrapper = new QueryWrapper<>();
        IPage<RookieEntity> selectPage = rookieMapper.selectPage(page, wrapper);

        System.out.println(selectPage.getRecords());
    }
}
