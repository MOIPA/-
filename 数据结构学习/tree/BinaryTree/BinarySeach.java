package BinaryTree;

public class BinarySeach {
	private Student[] data;
		
	public BinarySeach(int index){
		data = new Student[index];
		for(int i=0;i<data.length;i++){
			data[i] = new Student();
			data[i].ID=i;
		}
	}
	
	public Student Nsearch(int key){
		System.out.println("doing");
		int mid;
		for(int l = 0,r=data.length-1;l<=r;){
			mid = l+r/2;
			System.out.println("mid="+mid);
			Student obj = this.data[mid];
			if(obj.ID==key) return obj;
			if(obj.ID<key) r = mid-1;
			if(obj.ID>key) l = mid+1;
		}
		return null;
	}
	
	public Student search(int key,int l,int r){
		int mid = l+r/2;
		if(data[mid].ID==key)return data[mid];
		if(l>r) return null;
		else{
			if(data[mid].ID>key) return search(key,mid+1,r);
			if(data[mid].ID<key) return search(key,l,mid-1);
			}
		return null;
	}
	
}
