package com.kkb.item.interfaces;

import base.core.response.Result;
import com.kkb.item.domain.spu.Spu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kkb.item.application.SpuAppService;
import com.kkb.item.application.spu.param.SpuAddSpecParam;
import com.kkb.item.application.spu.param.SpuCreateParam;
import com.kkb.item.application.spu.param.SpuUpdateParam;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/v1/spu")
public class SpuRestApi {

    @Autowired
    private SpuAppService spuService;


    @PostMapping("/create")
    public Result<Long> create(@RequestBody SpuCreateParam param) {
        return Result.ok(spuService.save(param).getId());
    }


    /**
     * @param param
     * @return
     */
    @PostMapping("/updateBasic")
    public Result<Boolean> update(@RequestBody SpuUpdateParam param) {
        spuService.updateBasic(param);
        return Result.ok(true);
    }

    @PostMapping("/addSpecs")
    public Result<Boolean> addSpecs(@RequestBody SpuAddSpecParam param) {
        spuService.addSpecs(param);
        return Result.ok(true);
    }

    @GetMapping("/detail")
    public Result<Spu> findSpuById(Long shopId, Long spuId) {

        Optional<Spu> spu = spuService.findSpuById(shopId, spuId)
                .map(Spu::loadCategory)
                .map(Spu::loadUnit);

        return Result.ok(spu.orElse(null));
    }

    @GetMapping("/list")
    public Result<List<Spu>> listSpus(Long shopId) {
        return Result.ok(spuService.list(shopId).take(20).toList().blockingGet());
    }

}
