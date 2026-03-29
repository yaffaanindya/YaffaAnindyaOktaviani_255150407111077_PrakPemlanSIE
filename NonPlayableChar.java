class NonPlayableChar extends Character {

    public NonPlayableChar(String name) {
        this.name = name;
    }

    @Override
    public void doWork() {
        System.out.println("NPC " + this.name + " is wandering around.");
    }

    @Override
    public void kill(Character ch) {
        System.out.println(this.name + " (NPC) secretly killed " + ch.name + "!");
    }
}