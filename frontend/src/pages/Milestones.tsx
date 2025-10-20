import { useEffect, useState } from 'react'
import api from '../api'

export default function Milestones(){
  const [projectId, setProjectId] = useState('')
  const [list, setList] = useState<any[]>([])
  const load = async () => {
    if (!projectId) return
    const { data } = await api.get(`/api/projects/${projectId}/milestones`)
    setList(data)
  }
  useEffect(()=>{ if(projectId) load() },[projectId])
  return (
    <div>
      <h3>Milestones</h3>
      <div className="mb-3">
        <input placeholder="Project ID..." className="form-control" value={projectId} onChange={e=>setProjectId(e.target.value)} />
      </div>
      <button className="btn btn-primary mb-3" onClick={load}>Load</button>
      <ul className="list-group">
        {list.map(m => <li key={m.id} className="list-group-item">{m.title} — {m.description}</li>)}
      </ul>
    </div>
  )
}
