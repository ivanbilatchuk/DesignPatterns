package abstract_factory;

class IOSSound implements AlertSound {
    public void play() { System.out.println("iOS 'Chime' sound"); }
}