package prac.ds;

public class MyLinekdList<K, V> {
	private Node<K,V> node;
	
	

	private static class Node<K, V>{
		private K key;
		private V value;
		private Node next;
	}
	
	public static void main(String[] args) {
		MyLinekdList<String, String> list = new MyLinekdList();
		
		//list.add("Suhail", "BE");

	}

}
