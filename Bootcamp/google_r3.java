Given a list of email folders convert it into a list of Gmail labels.

Sample input:

Folder(id = 15, displayName = "subscriptions", parentId = -1)
Folder(id = 27, displayName = "comics", parentId = 15)
Folder(id = 35, displayName = "xkcd", parentId = 27)
Folder(id = 81, displayName = "oatmeal", parentId = 27)

Sample output:

Label(displayName="subscriptions")
Label(displayName="subscriptions/comics")
Label(displayName="subscriptions/comics/xkcd")
Label(displayName="subscriptions/comics/oatmeal")
  
public class Folder{
  int id;
  String displayName;
  int parentId;
  
  public Folder(){
  
  }
}

public class Label{
  String displayName;
  public Folder(displayName){
    this.displayName = displayName;
  }
}

public class FolderConnection{
  public List<Label> connectFolder(List<Folder> folders){
    Map<Integer,Folder> folderMapID = new HashMap(); 

    for(Folder folder : folders){
      folderMapID.put(folder.id, folder);
    }
    
    List<Label> results = new ArrayList<>();
    
    Map<Integer,String> cache;
    
    for(Folder folder : folders){
          Label lab = new Label();
          lab.displayName = findFolder(folder,folderMapID, cache); // lab null
          results.add(lab);
    }
    return results;
  }
  
  public String findFolder(Folder folder, Map<String,Folder> folderMapId, HashMap<Integer> visitedId, Map<Integer,String> cache){
    
    if(visitedId.contains(folder.id)) return null; 
    
    if(cache.containsKey(folder.id)){
      return cache.get(folder.id);
    }
    
    if(folderMapId.get(folders.id).parentId == -1){
      cache.put(folder.id, folder.displayName)
      return folder.displayName;
    }
    
    String parentLab = findFolder(folderMapId.get(folder.parentId), folderMapId);
    if(parentLab == null) return null;
    
    visitedId.add(folder.id);
    cache.put(folder.id, parentLab)
      
    return parentLab + "/" + folder.displayName;
  }
  
}
public class google_r3 {
    
}
