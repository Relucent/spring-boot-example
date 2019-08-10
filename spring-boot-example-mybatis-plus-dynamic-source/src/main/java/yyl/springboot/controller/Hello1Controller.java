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

import yyl.springboot.entity.Hello1;
import yyl.springboot.mapper.Hello1Mapper;

@RestController
@RequestMapping("/hello1")
public class Hello1Controller {

    @Autowired
    private Hello1Mapper hello1Mapper;

    // | /hello1/
    @GetMapping("/")
    public Object findAll() {
        return hello1Mapper.selectList(Wrappers.emptyWrapper());
    }

    // | /hello1/{id}
    @GetMapping("/{id}")
    public Object getById(@PathVariable Long id) {
        return hello1Mapper.selectById(id);
    }

    // | /hello1/
    @PostMapping("/")
    public Object save(@RequestBody Hello1 model) {
        Long id = model.getId();
        if (id == null) {
            hello1Mapper.insert(model);
        } else {
            hello1Mapper.updateById(model);
        }
        return Boolean.TRUE;
    }

    // | /hello1/{id}
    @PutMapping(value = "/{id}")
    public Object update(@PathVariable Long id, @RequestBody Hello1 model) {
        model.setId(id);
        hello1Mapper.updateById(model);
        return Boolean.TRUE;
    }

    // | /hello1/{id}
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        hello1Mapper.deleteById(id);
    }

}
