package yyl.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import yyl.springboot.entity.Hello2;
import yyl.springboot.mapper.Hello2Mapper;

@RestController
@RequestMapping("/hello2")
public class Hello2Controller {

    @Autowired
    private Hello2Mapper hello2Mapper;

    // | /hello2/
    @GetMapping("/")
    public Object findAll() {
        return hello2Mapper.selectList(Wrappers.emptyWrapper());
    }

    // | /hello2/{id}
    @GetMapping("/{id}")
    public Object getById(@PathVariable Long id) {
        return hello2Mapper.selectById(id);
    }

    // | /hello2/{id}
    @PostMapping("/")
    public Object save(@RequestBody Hello2 model) {
        Long id = model.getId();
        if (id == null) {
            hello2Mapper.insert(model);
        } else {
            hello2Mapper.updateById(model);
        }
        return Boolean.TRUE;
    }

    // | /hello/{id}
    @PutMapping(value = "/{id}")
    public Object update(@PathVariable Long id, @RequestBody Hello2 model) {
        model.setId(id);
        hello2Mapper.updateById(model);
        return Boolean.TRUE;
    }

    // | /hello/{id}
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        hello2Mapper.deleteById(id);
    }

}
