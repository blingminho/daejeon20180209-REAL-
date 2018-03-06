package mvcTest;

import java.util.List;

public class MemberService implements MemberServiceInf {
	private MemberDaoInf memDao;
	
	public MemberService() {
		// Service객체는 DAO객체를 사용해야 하기 때문에 DAO객체를 생성해야 한다.
		memDao = new MemberDao();
	}
	
	@Override
	public int insertMember(MemberVO memVo) {
		return memDao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String memId) {
		return memDao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		return memDao.updateMember(memVo);
	}

	@Override
	public List<MemberVO> getAllMember() {
		return memDao.getAllMember();
	}

	@Override
	public int getCountMember(String memId) {
		return memDao.getCountMember(memId);
	}

}
