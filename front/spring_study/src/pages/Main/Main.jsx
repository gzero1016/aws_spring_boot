import React, { useEffect, useState } from 'react';
import { deleteUser, getUserListAll, registerUser, updateUser } from '../../api/users';

function Main(props) {
    const emptyUser = {
        userId: "",
        username: "",
        name: "",
        phone: ""
    };

    const [ userInput, setUserInput ] = useState(emptyUser);

    const [ userList, setUserList ] = useState([]);

    const [ mode, setMode ] = useState(0);

    const requestGetUserListAll = () => {
        getUserListAll()
        .then(response => {
            setUserList(response.data);
        })
    }

    const Setting = () => {
        requestGetUserListAll();
        setUserInput(emptyUser);
        setMode(0);
    }

    // 로드되었을때 한번만 실행
    useEffect(() => {
        requestGetUserListAll();
    }, []);

    const handleUserInputChange = (e) => {
        setUserInput({
            ...userInput,
            [e.target.name] : e.target.value
        });
    }

    const handleRegisterClick = () => {
        setMode(1);
        setUserInput(emptyUser);
    }

    const handleRegisterSubmitClick = async() => {
        await registerUser(userInput);    //요청
        Setting();
    }
    
    const handleUpdateClick = async () => {
        await updateUser(userInput);
        Setting();
    }
    
    const handleDeleteClick = async() => {
        await deleteUser(userInput);
        Setting();
    }

    const handleSelectClick = (user) => {
        setMode(2);
        setUserInput(user);
    }

    return (
        <div>
            <div>
                <input type="text" name="userId" placeholder="userId" 
                    onChange={handleUserInputChange} value={userInput.userId}disabled />
            </div>
            <div>
                <input type="text" name="username" placeholder="username" 
                onChange={handleUserInputChange} value={userInput.username}disabled={mode === 0}/>
            </div>
            <div>
                <input type="text" name="name" placeholder="name" 
                onChange={handleUserInputChange} value={userInput.name}disabled={mode === 0}/>
            </div>
            <div>
                <input type="text" name="phone" placeholder="phone" 
                onChange={handleUserInputChange} value={userInput.phone}disabled={mode === 0}/>
            </div>
            {mode === 1 ? <button onClick={handleRegisterSubmitClick}>확인</button> : <button onClick={handleRegisterClick}>등록하기</button>}
            <button onClick={handleUpdateClick} disabled={mode !== 2}>수정하기</button>
            <button onClick={handleDeleteClick} disabled={mode !== 2}>삭제하기</button>
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>사용자명</th>
                            <th>이름</th>
                            <th>연락처</th>
                            <th>선택</th>
                        </tr>
                    </thead>
                    <tbody>
                        {userList.map(user => 
                            <tr key={user?.userId}>
                                <td>{user?.userId}</td>
                                <td>{user?.username}</td>
                                <td>{user?.name}</td>
                                <td>{user?.phone}</td>
                                {/* 클릭을 했을때 함수호출! */}
                                <td><button onClick={() => {handleSelectClick(user);}}>✔️</button></td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default Main;