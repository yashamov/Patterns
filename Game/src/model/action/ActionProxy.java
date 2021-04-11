package model.action;

import model.action.actions.Attack;
import model.hero.Hero;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;


//Выполняет промежуточные операции до и после запуска действия героя (логирование, наложение и снятие улучшения)
public class ActionProxy {
    //private static final Logger LOG = LoggerFactory.getLogger(ActionProxy.class);

    //действие
    private Action action;

    //Герой, выполняющий действие
    private Hero srcHero;

    //Герой назначение (на кого направлено действие)
    private Hero dstHero;

    public ActionProxy(Action action, Hero srcHero, Hero dstHero) {
        this.action = action;
        this.srcHero = srcHero;
        this.dstHero = dstHero;
    }

    //запуск действия
    public void execute() {
        //Улучшение
        Action skills = srcHero.getSkills();

        //Признак того, что атака осуществляется с улучшением
        boolean isAttackAndImprovement = action instanceof Attack && skills != null;

        //Если улучшение присутствует, умножаем урон на коэфф
        if (isAttackAndImprovement) {
            ((Attack) action).setImprovementRate(skills.getImprovementRate());
        }

        //LOG.info("{} {} {}", srcHero.getName(), action.getName(), dstHero.getNameGenitive());
        System.out.println(srcHero.getName() + " " + action.getName() + " " + dstHero.getNameGenitive());

        action.execute(dstHero);

        if (dstHero.getSkills() != null) {
            //LOG.info("{} здоровье: {} магия: {}", dstHero.getName(), dstHero.getHp(), dstHero.getSkills().getName());
            System.out.println(dstHero.getName() + " здоровье: " + dstHero.getHp() + " улучшение: " + dstHero.getSkills().getName());
        } else {
            //LOG.info("{} здоровье: {}", dstHero.getName(), dstHero.getHp());
            System.out.println(dstHero.getName() + " здоровье: " + dstHero.getHp());
        }

        //Снимаем улучшение с персонажа
        if (isAttackAndImprovement) {
            srcHero.restoreSkills();
        }

    }
}