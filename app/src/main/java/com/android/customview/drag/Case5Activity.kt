package com.android.customview.drag

import android.os.Bundle
import com.android.R
import com.kotlinlib.activity.KotlinActivity
import com.kotlinlib.other.LayoutId
import kotlinx.android.synthetic.main.activity_case7.*

@LayoutId(R.layout.activity_case7)
class Case5Activity : KotlinActivity() {
    override fun init(bundle: Bundle?) {
        tvDragMe.text = """
【环球时报驻朝鲜特派记者 莽九晨 环球时报特约记者 李静】朝鲜10日举行第十四届最高人民会议议员选举，投票工作在各地展开，《环球时报》记者当天来到位于平壤第四小学的投票站进行采访。

当天上午在前往投票站的路上，记者就看到各投票站已经开始排起了长队。朝鲜女性都身着艳丽的民族服装，男性都身穿西服，显示出他们对此次选举的重视。记者赶到平壤第四小学时，见到校园里已经人头攒动。据朝鲜中央选举委员会的现场工作人员介绍，此次选举只有一天，该选区的选民有3万余人。记者在现场看到，朝鲜民众在投票站入口处凭个人身份证件领取选票，然后进入半封闭的投票区进行投票。投票现场井然有序，气氛庄严肃穆。平壤观光大学四年级学生朴珍雅今年是第二次参加最高人民会议议员选举的投票，她表示，自己感觉心情十分激动，要认真投好庄严一票。

朝鲜最高人民会议是该国最高权力机关，其议员每五年选举产生。该机关的职能包括：批准、修改及补充宪法;选举国防委员会委员长、副委员长及委员;选举常任委员会委员长及委员;选举立法人员;任命内阁总理及阁员;听取内阁报告、监督内阁等。此次是朝鲜最高领导人金正恩执政后朝鲜第二次选举议员。据朝中社10日报道，当天上午11时，金正恩抵达位于金策工业综合大学的投票站参加投票。

韩联社称，鉴于第二次“金特会”无果而终，预计朝方将通过本届选举加强内部团结。朝鲜《劳动新闻》10日称，第十四届最高人民会议议员选举是进一步巩固人民主权、推动主体革命事业胜利前进的重要契机。全体公民要通过当天的选举，充分彰显朝鲜一心团结的威力、乘胜前进的不可战胜性和威仪。韩联社的报道还表示，此次换届含有金正恩第二届领导班子“整装待发”的意义，第十三届最高人民会议议员选举后崭露头角的一批党政军新贵有望当选新一届议员。参照上届先例，新一届议员名单很可能于选举结束一两天内，即11日-12日公布。
        """.trimIndent()
    }
}
