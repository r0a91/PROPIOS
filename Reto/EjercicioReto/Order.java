public interface Order {
  public double accept(OrderVisitor v);
}
