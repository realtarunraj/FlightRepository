import React from 'react'
import { useLocation } from 'react-router-dom';
import ADelete from '../component/adelete';

export default function AdminDelete(props) {
    const location=useLocation()
    var admin = location.state.data;
    return (<>
      <ADelete data={admin} />
      </>)
}
