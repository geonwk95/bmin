import { useContext, useEffect, useState } from "react"
import axios from "axios";
import { RenderContext } from "./Packaging";

export default function PackagingTotalBox(props){

    // 재 랜더링용
    // - provider 컴포넌트의 value 호출
    const { render ,setRender } = useContext(RenderContext);

    const [previous , setPrevious] = useState(0);
    const [now , setNow] = useState(0);
    const [success , setSuccess] = useState(0);
    const [fail , setFail] = useState(0);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get("/wp/list/get.do");
                const filteredData = response.data.filter((result) => result.wstate <= 8);
                setPrevious(filteredData.length);
            } catch (error) {
                console.log(error);
            }
        };

        const fetchData2 = async () => {
            try {
                const response2 = await axios.get('/packaging/info/get.do');
                const nowlength = response2.data.filter((result) => result.sdstate === 0);
                const successlength = response2.data.filter((result) => result.sdstate === 2);
                const faillength = response2.data.filter((result) => result.sdstate === 1);
                setNow(nowlength.length);
                setSuccess(successlength.length);
                setFail(faillength.length);
            } catch (error) {
                console.log(error);
            }
        };
    
        fetchData();
        fetchData2();
      }, [render]);

    return(
        <div className="statistics">
            <h3>통계</h3>
            <div className="statisticsWrap">
                <div className="statisticsBox">
                    <p className="statisticsBoxFont2">진행전</p>
                    <div id="statisticsBoxFont">{previous}개</div>
                </div>
                <div className="statisticsBox">
                    <p className="statisticsBoxFont2">진행중</p> 
                    <div id="statisticsBoxFont">{now}개</div>
                </div>
                <div className="statisticsBox">
                    <p className="statisticsBoxFont2">완료</p>
                    <div id="statisticsBoxFont">{success}개</div>
                </div>
                <div className="statisticsBox">
                    <p className="statisticsBoxFont2">불합격</p> 
                    <div id="statisticsBoxFont">{fail}개</div>
                </div>
            </div>
        </div>
    )
}