package com.fuqi.designmodellearn.proxymodellearn.normalproxy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author FuQi
 * @date 2023/3/5 14:56
 * @description
 */
public class CeoAssistant implements CeoOffice {
    private Ceo ceo;

    public CeoAssistant(Ceo ceo) {
        this.ceo = ceo;
    }

    @Override
    public Boolean talkAppointment(String visitor) {
        List<String> canVisitList = Stream.of("family member", "supplier", "business partner", "other manager").collect(Collectors.toList());
        if (visitor != null && !"".equals(visitor) && canVisitList.contains(visitor)) {
            System.out.println("在助理咨询CEO是否需要谈话的名单中，等待CEO的确认");
            return ceo.talkAppointment(visitor);
        }
        System.out.println("来访者不在助理咨询CEO是否需要谈话的名单中，不能与CEO谈话");

        return Boolean.FALSE;
    }

    @Override
    public void releaseAnnouncement(int announceNum) {
        System.out.println("Assistant为CEO准备第" + announceNum + "号声明的纸质资料");
        ceo.releaseAnnouncement(announceNum);
        System.out.println("Assistant发布CEO签署好的第" + announceNum + "声明。");
    }
}
