import { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import api from '../api'

export default function ProjectDetails(){
  const { id } = useParams()
  const [p, setP] = useState<any>(null)
  useEffect(()=>{ (async ()=>{
    const { data } = await api.get(`/api/projects/${id}`)
    setP(data)
  })() },[id])
  if (!p) return <div>Loading...</div>
  return (
    <div>
      <h3>{p.title}</h3>
      <p>{p.summary}</p>
      <div>Status: <b>{p.status}</b></div>
      <div>Tags: {p.tags}</div>
    </div>
  )
}
