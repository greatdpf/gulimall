<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="sku_id" prop="skuId">
      <el-input v-model="dataForm.skuId" placeholder="sku_id"></el-input>
    </el-form-item>
    <el-form-item label="å›¾ç‰‡åœ°å€" prop="imgUrl">
      <el-input v-model="dataForm.imgUrl" placeholder="å›¾ç‰‡åœ°å€"></el-input>
    </el-form-item>
    <el-form-item label="æŽ’åº" prop="imgSort">
      <el-input v-model="dataForm.imgSort" placeholder="æŽ’åº"></el-input>
    </el-form-item>
    <el-form-item label="é»˜è®¤å›¾[0 - ä¸æ˜¯é»˜è®¤å›¾ï¼Œ1 - æ˜¯é»˜è®¤å›¾]" prop="defaultImg">
      <el-input v-model="dataForm.defaultImg" placeholder="é»˜è®¤å›¾[0 - ä¸æ˜¯é»˜è®¤å›¾ï¼Œ1 - æ˜¯é»˜è®¤å›¾]"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          skuId: '',
          imgUrl: '',
          imgSort: '',
          defaultImg: ''
        },
        dataRule: {
          skuId: [
            { required: true, message: 'sku_id不能为空', trigger: 'blur' }
          ],
          imgUrl: [
            { required: true, message: 'å›¾ç‰‡åœ°å€不能为空', trigger: 'blur' }
          ],
          imgSort: [
            { required: true, message: 'æŽ’åº不能为空', trigger: 'blur' }
          ],
          defaultImg: [
            { required: true, message: 'é»˜è®¤å›¾[0 - ä¸æ˜¯é»˜è®¤å›¾ï¼Œ1 - æ˜¯é»˜è®¤å›¾]不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/product/skuimages/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.skuId = data.skuImages.skuId
                this.dataForm.imgUrl = data.skuImages.imgUrl
                this.dataForm.imgSort = data.skuImages.imgSort
                this.dataForm.defaultImg = data.skuImages.defaultImg
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/product/skuimages/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'skuId': this.dataForm.skuId,
                'imgUrl': this.dataForm.imgUrl,
                'imgSort': this.dataForm.imgSort,
                'defaultImg': this.dataForm.defaultImg
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
