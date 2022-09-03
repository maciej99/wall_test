interface Structure {
// zwraca dowolny element o podanym kolorze
Optional findBlockByColor(String color);

// zwraca wszystkie elementy z danego materiału
List findBlocksByMaterial(String material);

//zwraca liczbę wszystkich elementów tworzących strukturę
int count();
}

public class Wall implements Structure {
  private List blocks;

  public Optional findBlockByColor(String color){
 	  int size = blocks.size();
	  Block block;
   	int i = -1;
	  while(++i<size){
  		block = blocks.get(i);
  		String c = block.getColor();
	  	// gdy znajdziemy zadany kolor zwróć ten block, zrób type-casting na Optional
	  	if(c.equals(color)) return (Optional) block; 
	  }
  	// jesli pętla wykona się do końca nie znajdując żadnego elementu 
  	// o zadanym kolorze, zwróć null
  	return null;
  }

  public List findBlocksByMaterial(String material){
	  // utwórz nową listę
  	List<Block> matching = new List<>();
  	int size = blocks.size();
  	Block block;
  	int i = -1;
  	while(++i<size){
	  	block = blocks.get(i);
	  	String m = block.getMaterial();
	  	// gdy znajdziemy zadany material dodaj do listy matching
	  	if(m.equals(material)) matching.add(block); 
	  }
	  // zwróć listę matching
	  return matching; 
  }

  public int count(){
	  return blocks.size();
  }
}

interface Block {
  String getColor();
  String getMaterial();
}

interface CompositeBlock extends Block {
  List getBlocks();
}
