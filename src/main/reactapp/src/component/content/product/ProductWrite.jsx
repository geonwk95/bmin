import axios from "axios";
import { useState } from "react";

export default function ProductWrite(props){

    // axios.post("/product/post.do")
    const [pname,setPname] = useState("");

    const doPost = ()=>{
        const formData = new FormData();
        formData.append("pname",pname);
        axios.post("/product/post.do",formData).then( r=> {console.log(r.data)}).catch(e=>{console.log(e)})
    }
    return(<>
        <input value={pname} onChange={(e)=>{setPname(e.target.value)}}/>
        <button type="button" onClick={doPost}>제품 등록</button>
    </>)
}