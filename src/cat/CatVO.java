package cat;

public class CatVO {
	private int idx;
	private String kind;
	private String name;
	private String gender;
	private String fDate;
	private String features;
	private String photo;
	private String missing;
	private String singoja;
	private String singotel;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getfDate() {
		return fDate;
	}
	public void setfDate(String fDate) {
		this.fDate = fDate;
	}
	public String getSingoja() {
		return singoja;
	}
	public void setSingoja(String singoja) {
		this.singoja = singoja;
	}
	public String getSingotel() {
		return singotel;
	}
	public void setSingotel(String singotel) {
		this.singotel = singotel;
	}
	public String getMissing() {
		return missing;
	}
	public void setMissing(String missing) {
		this.missing = missing;
	}
	
	@Override
	public String toString() {
		return "CatVO [idx=" + idx + ", kind=" + kind + ", name=" + name + ", gender=" + gender + ", fDate=" + fDate
				+ ", features=" + features + ", photo=" + photo + ", missing=" + missing + ", singoja=" + singoja
				+ ", singotel=" + singotel + "]";
	}
}
