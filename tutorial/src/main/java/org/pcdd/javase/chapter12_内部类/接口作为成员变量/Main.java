package org.pcdd.javase.chapter12_内部类.接口作为成员变量;

interface Skill {
    void use();
}

class Hero {
    private String name;
    private Skill skill;

    public Hero() {
    }

    public void attack() {
        System.out.println("我是" + this.name);
        this.skill.use();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero();
        hero1.setName("艾希");
        hero1.setSkill(new Skill() {
            @Override
            public void use() {
                System.out.println("正在使用【万箭齐发】攻击敌方");
            }
        });
        hero1.attack();

    }
}
